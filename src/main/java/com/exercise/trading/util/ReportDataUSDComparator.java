package com.exercise.trading.util;

import java.util.Comparator;

import com.exercise.trading.domain.ReportData;

public class ReportDataUSDComparator implements Comparator<ReportData>{

	@Override
	public int compare(ReportData o1, ReportData o2) {
		return (o1.getUSD()).compareTo(o2.getUSD());
	}

}
