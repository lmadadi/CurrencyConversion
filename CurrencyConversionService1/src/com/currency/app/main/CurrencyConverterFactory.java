package com.currency.app.main;

import com.currency.app.service.CurrencyConverterService;
import com.currency.app.service.EuroCurrencyConverterServiceImpl;
import com.currency.app.service.IndianRupeeConverterServiceImpl;
import com.currency.app.service.USACurrencyConverterServiceImpl;

public class CurrencyConverterFactory {

	// use getCurrency method to get object of type Currency
	public CurrencyConverterService getCurrencyConvertor(String currencyType) {
		if (currencyType == null) {
			return null;
		}
		if (currencyType.equalsIgnoreCase("USA")) {
			return new USACurrencyConverterServiceImpl();

		} else if (currencyType.equalsIgnoreCase("INR")) {
			return new IndianRupeeConverterServiceImpl();

		} else if (currencyType.equalsIgnoreCase("EURO")) {
			return new EuroCurrencyConverterServiceImpl();
		}

		return null;
	}
}