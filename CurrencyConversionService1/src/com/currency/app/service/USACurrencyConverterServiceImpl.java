package com.currency.app.service;

import java.util.ArrayList;
import java.util.List;

import com.currency.app.enums.USACoin;

public class USACurrencyConverterServiceImpl implements CurrencyConverterService {
	
	/**
	 * This class implements CurrencyConverterService
	 * taking arguments as currency 
	 * 
	 */

	@Override
	public List<String> convert(int currency) {
		List<String> result = new ArrayList<>();
		int dollars = 0;
		int quarters = 0;
		int dimes = 0;
		int pennies = 0;
		int nickle = 0;

		if (currency > 100) {
			dollars = Math.round((int) currency / USACoin.DOLLAR.getDenomination());
			currency = currency % USACoin.DOLLAR.getDenomination();
		}
		if (currency > 25) {
			quarters = Math.round((int) currency / USACoin.QUARTER.getDenomination());
			currency = currency % USACoin.QUARTER.getDenomination();
		}
		if (currency > 10) {
			dimes = Math.round((int) currency / USACoin.DIME.getDenomination());
			currency = currency % USACoin.DIME.getDenomination();
		}
		
		if (currency > 5) {
			nickle = Math.round((int) currency / USACoin.NICKEL.getDenomination());
			currency = currency % USACoin.NICKEL.getDenomination();
		}

		pennies = Math.round((int) currency / USACoin.PENNY.getDenomination());

		result.add("Number of Dollars: " + dollars);
		result.add("Number of Quarters: " + quarters);
		result.add("Number of Dimes: " + dimes);
		result.add("Number of Nickle: " + nickle);
		result.add("Number of Pennies: " + pennies);

		return result;
	}

}
