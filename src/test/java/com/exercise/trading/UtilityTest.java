package com.exercise.trading;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.exercise.trading.domain.TradingDay;
import com.exercise.trading.domain.TradingDay.Currency;
import com.exercise.trading.util.Utility;

public class UtilityTest {
	
	@Test
	public void getNextProcessingDate(){
		String date = Utility.getNextProcessingDay(Currency.AED, "05 Oct 2018");
		assertNotNull(date);
	}
	
	@Test
	public void getSampleData(){
		List<TradingDay> tradingDayList = Utility.getSampleData();
		assertNotNull(tradingDayList);
	}
	
	@Test
	public void testIsDateonWeekend(){
		boolean flag = Utility.isStmntDayOnWeekend("05 Oct 2018");
		assertFalse(flag);
	}
	
	@Test
	public void testGetDate(){
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 10, 05);
		boolean flag = Utility.isStmntDayOnWeekend(cal.getTime());
		assertFalse(flag);
	}

}
