package com.currency.app2.main;

import java.util.Scanner;

import com.currency.app2.service.CurrencyProcessor;
import com.currency.app2.service.CurrencyProcessorServiceImpl;

public class CurrencyConverterMain {

	/*
	 * Driver class to run the functionality passing amount(lowest
	 * currency),countryName as parameters
	 * 
	 */

	public static void main(String[] args) {
		try {
			CurrencyProcessor cp = new CurrencyProcessorServiceImpl();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the balance:");
			int amount = sc.nextInt();
			String currencyName = "USD";
			cp.loadDenominations(amount, currencyName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("oops ! Failed to convert to required denominations");
		}
	}
}
