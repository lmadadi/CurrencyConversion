package com.currency.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="CURRENCY_MAPPING")
@DynamicUpdate
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currencyId;
	private String currencyDesc;
	private String currencyCode;
	private Double amountValue;
	private Integer convertionRate;

	public Integer getConvertionRate() {
		return convertionRate;
	}

	public void setConvertionRate(Integer convertionRate) {
		this.convertionRate = convertionRate;
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyDesc() {
		return currencyDesc;
	}

	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(Double amountValue) {
		this.amountValue = amountValue;
	}

}
