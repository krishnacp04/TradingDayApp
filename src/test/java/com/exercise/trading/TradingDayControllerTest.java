package com.exercise.trading;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.exercise.trading.controller.TradingController;
import com.exercise.trading.service.TradingService;

public class TradingDayControllerTest {
	
	@InjectMocks
	public TradingController tradingController;
	
	@Mock
	public TradingService tradingService;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testProcessData(){
		tradingController.processData();
	}
}
