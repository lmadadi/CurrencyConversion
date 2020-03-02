package com.currency.app.main;

import java.util.List;
import java.util.Scanner;

import com.currency.app.service.CurrencyConverterService;

public class CurrencyMain {

	public static void main(String[] args) {
		
		//Factory design pattern
		CurrencyConverterFactory factory = new CurrencyConverterFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the balance:");
		int balance = sc.nextInt();
		
		CurrencyConverterService usaservice = factory.getCurrencyConvertor("USA");
		List<String> result = usaservice.convert(balance);
		
		result.forEach(System.out::println);
		
	}

}
