package com.currency.app.service;

import java.util.List;

import com.currency.app.entity.CurrencyEntity;
import com.currency.app.utilities.CurrencyResponse;

public interface CurrencyService {


	/**
	 * @param entity
	 * @return
	 */
	public CurrencyResponse createNewCurrency(CurrencyEntity entity);

	/**
	 * @param currencyCode
	 * @param amount
	 * @param desc
	 * @return
	 */
	public CurrencyResponse updateCurrency(String currencyCode, Double amount, String desc);

	/**
	 * @param currencyCode
	 * @param amount
	 * @return
	 */
	public CurrencyResponse getCurrency(String currencyCode, Double amount); 

	/**
	 * @param currencyCode
	 * @param amount
	 * @return
	 */
	public CurrencyResponse deleteCurrency(String currencyCode, Double amount);

	/**
	 * @param loadAllCurrency
	 * @return
	 */
	public CurrencyResponse loadAllCurrency(List<CurrencyEntity> loadAllCurrency);

	/**
	 * @param currencyCode
	 * @return
	 */
	public CurrencyResponse getCurrency(String currencyCode);

}
