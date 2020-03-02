package com.currency.app2.entity;

public class DenominationLoader {

	private String countryCurrency;
	private String denominationNames;
	private double denominationValues;

	public String getCountryCurrency() {
		return countryCurrency;
	}

	public void setCountryCurrency(String countryCurrency) {
		this.countryCurrency = countryCurrency;
	}

	public String getDenominationNames() {
		return denominationNames;
	}

	public void setDenominationNames(String denominationNames) {
		this.denominationNames = denominationNames;
	}

	public double getDenominationValues() {
		return denominationValues;
	}

	public void setDenominationValues(double denominationValues) {
		this.denominationValues = denominationValues;
	}

}
