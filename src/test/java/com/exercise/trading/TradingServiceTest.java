package com.exercise.trading;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.exercise.trading.domain.ReportData;
import com.exercise.trading.domain.SettlementInstruction;
import com.exercise.trading.domain.TradingDay;
import com.exercise.trading.service.TradingService;
import com.exercise.trading.util.Utility;
@RunWith(MockitoJUnitRunner.class)
public class TradingServiceTest {
	
	@InjectMocks
	public TradingService tradingService;
	
	public void setup(){
		MockitoAnnotations.initMocks(this);
		tradingService = Mockito.spy(TradingService.class);
	}

	@Test
	public void getSettlementInstruction(){
		List<TradingDay> tradingDayList = Utility.getSampleData();
		List<SettlementInstruction> settlementInstructionsList = tradingService.getSettlmentInstruction(tradingDayList);
		assertTrue(settlementInstructionsList.size() > 0);
	}
	
	@Test
	public void processData(){
		List<TradingDay> tradingDayList = Utility.getSampleData();
		List<ReportData> reportDataList = tradingService.processData(tradingDayList);
		assertTrue(reportDataList.size() > 0);
	}
}
