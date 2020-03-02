package com.currency.app.utilities;

import java.util.List;
import java.util.Map;

import com.currency.app.entity.CurrencyEntity;

public abstract class AbstractFactory {
	
	/**
	 * @param amount
	 * @param currencyList
	 * @param responseMap
	 */
	public abstract void getCurrency(Double amount, List<CurrencyEntity> currencyList,
			Map<String, Object> responseMap);	

}
