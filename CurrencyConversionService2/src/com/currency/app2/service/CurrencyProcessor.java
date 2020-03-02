package com.currency.app2.service;

import java.io.IOException;
import java.text.ParseException;

public interface CurrencyProcessor    {
	
	public void loadDenominations(int amount, String currencyName)
			throws IOException, ParseException;
}
