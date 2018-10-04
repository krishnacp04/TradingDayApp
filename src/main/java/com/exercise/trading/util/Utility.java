package com.exercise.trading.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.exercise.trading.domain.ReportData;
import com.exercise.trading.domain.TradingDay;
import com.exercise.trading.domain.TradingDay.Currency;
import com.exercise.trading.domain.TradingDay.Option;

public class Utility {

	public static boolean isStmntDayOnWeekend(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
			return true;
		}
		return false;
	}
	
	public static Date convertStringToDate(String stringDate){
		String[] datearray = stringDate.split(" ");
		String dateVal = datearray[0]+"/"+datearray[1]+"/"+datearray[2];
	    Date date = null;
		try {
			date = new SimpleDateFormat("dd/MMM/yyyy").parse(dateVal);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    return date;
	}
	
	public static boolean isStmntDayOnWeekend(String date){
		return isStmntDayOnWeekend(convertStringToDate(date));
	}
	
	public static String getNextProcessingDay(Currency currency, String strDate){
		Date date = convertStringToDate(strDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		if(Currency.AED.equals(currency) || Currency.SAR.equals(currency)){
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
				calendar.add(Calendar.DATE, 2);
			}else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				calendar.add(Calendar.DATE, 1);
			}
		}else{
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				calendar.add(Calendar.DATE, 2);
			}else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				calendar.add(Calendar.DATE, 1);
			}
		}
		String settlementDate = new SimpleDateFormat("dd MMM yyyy").format(calendar.getTime());
		return settlementDate;
	}
	
	public static List<TradingDay> getSampleData(){
		List<TradingDay> tradingDayList = new ArrayList<>();
		
		TradingDay tradingDay1 = new TradingDay();
		tradingDay1.setAgreedFX(0.50);
		tradingDay1.setCurrency(Currency.SGP);
		tradingDay1.setEntity("foo");
		tradingDay1.setInstructionDate("06 Oct 2016");
		tradingDay1.setSettlementDate("07 Oct 2018");
		tradingDay1.setUnits(200);
		tradingDay1.setPricePerUnit(100.25);
		tradingDay1.setOption(Option.BUY);
		
		TradingDay tradingDay5 = new TradingDay();
		tradingDay5.setAgreedFX(0.50);
		tradingDay5.setCurrency(Currency.SGP);
		tradingDay5.setEntity("foo");
		tradingDay5.setInstructionDate("04 Oct 2016");
		tradingDay5.setSettlementDate("05 Oct 2018");
		tradingDay5.setUnits(200);
		tradingDay5.setPricePerUnit(100.25);
		tradingDay5.setOption(Option.BUY);
		
		TradingDay tradingDay6 = new TradingDay();
		tradingDay6.setAgreedFX(0.50);
		tradingDay6.setCurrency(Currency.SGP);
		tradingDay6.setEntity("foo1");
		tradingDay6.setInstructionDate("04 Oct 2016");
		tradingDay6.setSettlementDate("05 Oct 2018");
		tradingDay6.setUnits(100);
		tradingDay6.setPricePerUnit(100.25);
		tradingDay6.setOption(Option.BUY);
		
		TradingDay tradingDay2 = new TradingDay();
		tradingDay2.setAgreedFX(0.22);
		tradingDay2.setCurrency(Currency.AED);
		tradingDay2.setEntity("bar");
		tradingDay2.setInstructionDate("04 Oct 2016");
		tradingDay2.setSettlementDate("05 Oct 2018");
		tradingDay2.setUnits(450);
		tradingDay2.setPricePerUnit(150.5);
		tradingDay2.setOption(Option.SELL);
		
		TradingDay tradingDay3 = new TradingDay();
		tradingDay3.setAgreedFX(0.60);
		tradingDay3.setCurrency(Currency.SAR);
		tradingDay3.setEntity("car");
		tradingDay3.setInstructionDate("06 Oct 2018");
		tradingDay3.setSettlementDate("07 Oct 2018");
		tradingDay3.setUnits(250);
		tradingDay3.setPricePerUnit(120.75);
		tradingDay3.setOption(Option.BUY);
		
		TradingDay tradingDay4 = new TradingDay();
		tradingDay4.setAgreedFX(0.85);
		tradingDay4.setCurrency(Currency.GBP);
		tradingDay4.setEntity("coo");
		tradingDay4.setInstructionDate("04 Oct 2018");
		tradingDay4.setSettlementDate("05 Oct 2018");
		tradingDay4.setUnits(300);
		tradingDay4.setPricePerUnit(90.25);
		tradingDay4.setOption(Option.SELL);
		
		tradingDayList.add(tradingDay1);
		tradingDayList.add(tradingDay2);
		tradingDayList.add(tradingDay3);
		tradingDayList.add(tradingDay4);
		tradingDayList.add(tradingDay5);
		tradingDayList.add(tradingDay6);
		return tradingDayList;
	}

	public static void printData(List<ReportData> reportDataList, String entityType) {
		System.out.println("Report on " + new Date()+ " for Entity Type : " + entityType);
		System.out.println("USD" + "\t\t" + "Entity");
		System.out.println("-------------------------------------------------");
		Collections.sort(reportDataList, new ReportDataUSDComparator());
		Collections.reverse(reportDataList);
		if(null != reportDataList && reportDataList.size() > 0){
			reportDataList.forEach(reportData-> System.out.println(reportData));
		}else{
			System.out.println("No Records on this Trading day.");
		}
		System.out.println();
	}
	
}
