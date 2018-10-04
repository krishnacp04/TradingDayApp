package com.exercise.trading.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReportData implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigDecimal incomingUSD;
	private BigDecimal outgoingUSD;
	private BigDecimal USD;
	private String entity;
	private String entityType;
	
	public BigDecimal getIncomingUSD() {
		return incomingUSD;
	}
	public void setIncomingUSD(BigDecimal incomingUSD) {
		this.incomingUSD = incomingUSD;
	}
	public BigDecimal getOutgoingUSD() {
		return outgoingUSD;
	}
	public void setOutgoingUSD(BigDecimal outgoingUSD) {
		this.outgoingUSD = outgoingUSD;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	@Override
	public String toString() {
		return USD + "\t\t" + entity;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public BigDecimal getUSD() {
		return USD;
	}
	public void setUSD(BigDecimal uSD) {
		USD = uSD;
	}
	
}
