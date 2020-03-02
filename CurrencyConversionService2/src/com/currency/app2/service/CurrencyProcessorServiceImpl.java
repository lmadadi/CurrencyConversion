/**
 * 
 */
package com.currency.app2.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.currency.app2.entity.DenominationGenerator;
import com.currency.app2.entity.DenominationLoader;

public class CurrencyProcessorServiceImpl implements CurrencyProcessor {
	
	/*
	 * This is the core class which will process the given lowest unit of currency
	 * (e.g. pennies for USD).
	 * 
	 * LoadDenominations will based on its input will parse the input and builds
	 * DenominationLoader.java Here the data input is read from a CSV file. But can
	 * be extended to database and other data input types
	 * 
	 * The values from DenominationLoader and then added to denoList. The denoList
	 * is then sorted based on the denomination values The denoList is then iterated
	 * for the denomination values. Since the balance is given in lowest unit of
	 * currency all the denomination values are converted into lowest unit by
	 * multiplying with 100 The balance is then divided by the denomination value
	 * and dividend which is number of bills/coins for the denomination is captured
	 * New balance is computed by subtracting the above computed
	 * (dividend*denomination) value New balance is then checked against other
	 * values in the list and the process is continued till the balance reaches 0 or
	 * there are no more denominations in the input left to compute the bill/coin
	 * breakdown.
	 * 
	 */
	
	@Override
	public void loadDenominations(int amount, String currencyName)
			throws IOException, ParseException {
		String configPath = "C:/Workspace/NYHX-Development/CurrencyConverterService2/Currency_denomination.csv";
		List<DenominationLoader> denolist = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(configPath));
		String currentLine = null;
		while ((currentLine = br.readLine()) != null) {
			String str[] = currentLine.split(",");
			if (str[0] != null && str[0].equals(currencyName) && !"".equals(str[1]) && str.length == 3) {
				DenominationLoader denominationLoader = new DenominationLoader();
				denominationLoader.setCountryCurrency(str[0]);
				denominationLoader.setDenominationNames(str[2]);
				denominationLoader.setDenominationValues(Double.parseDouble(str[1]));
				denolist.add(denominationLoader);
			}
		}
		Collections.sort(denolist, new Comparator<DenominationLoader>() {
			@Override
			public int compare(DenominationLoader d1, DenominationLoader d2) {
				return Double.compare(d2.getDenominationValues(), d1.getDenominationValues());
			}
		});
		if (denolist.size() != 0) {
			for (DenominationLoader denoLoader1 : denolist) {
				int tempamount = (int) (denoLoader1.getDenominationValues() * 100);
				if (amount >= tempamount) {
					int noteCounter = (int) (amount / tempamount);
					amount = amount - noteCounter * tempamount;
					System.out.println("Number of " + denoLoader1.getDenominationNames() + ":" + noteCounter);
				}
			}
			if (amount != 0) {
				System.out.println("This balance cannot be computed with given input denominations" + amount);
			}
		} else {
			System.out.println("Given Country currency is not configured in database - Please check the Currency Name!!!");
		}
	}

}
