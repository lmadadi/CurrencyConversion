package com.currency.app.utilities;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.currency.app.entity.CurrencyEntity;

public class IndianCurrency extends AbstractFactory {
	
	private static final Logger log = LoggerFactory.getLogger(IndianCurrency.class);

	@Override
	public void getCurrency(Double amount, List<CurrencyEntity> currencyList,
			Map<String, Object> responseMap) {
		log.info("Inside IndianCurrency class, getCurrency method");
		int count = 0;
		Integer convertionRate = currencyList.get(0).getConvertionRate();
		if (convertionRate != null && convertionRate > 0) {
			amount = amount / convertionRate;
		}
		for (CurrencyEntity currency : currencyList) {
			count = (int) (amount / currency.getAmountValue());
			if (count != 0) {
				responseMap.put(currency.getCurrencyDesc(), count);
				amount = amount % currency.getAmountValue();
			}
		}
	}
}
