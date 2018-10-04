package com.exercise.trading.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.trading.domain.ReportData;
import com.exercise.trading.domain.TradingDay;
import com.exercise.trading.domain.TradingDay.Option;
import com.exercise.trading.service.TradingService;
import com.exercise.trading.util.Utility;

@RestController
public class TradingController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TradingService tradingService;
	
	@RequestMapping("/healthCheck")
	public String healthCheck(){
		LOGGER.debug("This is a debug message");
	    LOGGER.info("This is an info message");
	    LOGGER.warn("This is a warn message");
	    LOGGER.error("This is an error message");
		return "Trading service is up and running...";
	}
	
	@RequestMapping("/processData")
	@Scheduled(cron="0 0 17 * * *")
	public String processData(){
		String msg = "Data Processed Successfully";
		List<ReportData> reportDataList = null;
		try {
			List<TradingDay> tradingDayList = Utility.getSampleData();
			if(null != tradingDayList && tradingDayList.size() > 0){
				reportDataList = tradingService.processData(tradingDayList);
				List<ReportData> reportDataListIncoming = reportDataList.stream().filter(reportData->reportData.getEntityType()
						.equalsIgnoreCase(Option.SELL.toString())).collect(Collectors.toList());
				Utility.printData(reportDataListIncoming, Option.SELL.toString());
				List<ReportData> reportDataListOutGoing = reportDataList.stream().filter(reportData->reportData.getEntityType()
						.equalsIgnoreCase(Option.BUY.toString())).collect(Collectors.toList());
				Utility.printData(reportDataListOutGoing, Option.BUY.toString());
			}
		} catch (Exception e) {
			msg = "Data Failed to Process, Please check the logs..";
			e.printStackTrace();
			LOGGER.error(e.getMessage() + "  : " + e.getStackTrace());
		}
		return msg;
	}

}
