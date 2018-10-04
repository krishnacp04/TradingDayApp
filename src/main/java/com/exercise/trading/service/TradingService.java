package com.exercise.trading.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.trading.domain.ReportData;
import com.exercise.trading.domain.SettlementInstruction;
import com.exercise.trading.domain.TradingDay;
import com.exercise.trading.domain.TradingDay.Option;
import com.exercise.trading.util.Utility;

@Service
public class TradingService {
	
	public List<SettlementInstruction> getSettlmentInstruction(List<TradingDay> tradingDayList){
		List<SettlementInstruction> settlementInstruction = new ArrayList<SettlementInstruction>();
		for(TradingDay day : tradingDayList){
			SettlementInstruction si = new SettlementInstruction();
			si.setAgreedFX(day.getAgreedFX());
			si.setSettlementDate(Utility.getNextProcessingDay(day.getCurrency(), day.getSettlementDate()));
			si.setCurrency(day.getCurrency().toString());
			si.setOption(day.getOption().toString());
			si.setEntity(day.getEntity());
			si.setInstructionDate(day.getInstructionDate());
			si.setPricePerUnit(day.getPricePerUnit());
			si.setUnits(day.getUnits());
			settlementInstruction.add(si);
		}
		return settlementInstruction;
	}
	
	
	public List<ReportData> processData(List<TradingDay> tradingDayList){
		List<SettlementInstruction> settlementList = getSettlmentInstruction(tradingDayList);
		List<ReportData> reportDataList = new ArrayList<ReportData>();
		for(SettlementInstruction day : settlementList){
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy");
			try {
				Date date = dateFormatter.parse(dateFormatter.format(new Date()));
				String currentDate = dateFormatter.format(date);
				if(currentDate.compareTo(day.getSettlementDate())== 0){
					ReportData reportData = new ReportData();
					Double val = day.getAgreedFX()*day.getPricePerUnit()*day.getUnits();
					reportData.setUSD(new BigDecimal(val, MathContext.DECIMAL64).setScale(2, RoundingMode.DOWN));
					if(day.getOption().equals(Option.BUY.toString())){
						reportData.setEntityType(Option.BUY.toString());
					}
					if(day.getOption().equals(Option.SELL.toString())){
						reportData.setEntityType(Option.SELL.toString());
					}
					reportData.setEntity(day.getEntity());
					reportDataList.add(reportData);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return reportDataList;
	}

}
