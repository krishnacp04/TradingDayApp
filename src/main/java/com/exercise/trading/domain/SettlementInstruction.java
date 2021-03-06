package com.exercise.trading.domain;

import java.io.Serializable;

public class SettlementInstruction implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String option;
	private String entity;
	private double agreedFX;
	private String currency;
	private String instructionDate;
	private String settlementDate;
	private int units;
	private double pricePerUnit;
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public double getAgreedFX() {
		return agreedFX;
	}
	public void setAgreedFX(double agreedFX) {
		this.agreedFX = agreedFX;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public String getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(String instructionDate) {
		this.instructionDate = instructionDate;
	}
	public String getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	@Override
	public String toString() {
		return "TradingDay [option=" + option + ", entity=" + entity + ", agreedFX=" + agreedFX + ", currency="
				+ currency + ", instructionDate=" + instructionDate + ", settlementDate=" + settlementDate + ", units="
				+ units + ", pricePerUnit=" + pricePerUnit + "]";
	}
}
