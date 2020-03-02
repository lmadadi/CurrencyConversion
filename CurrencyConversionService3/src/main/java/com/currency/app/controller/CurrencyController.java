package com.currency.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.currency.app.entity.CurrencyEntity;
import com.currency.app.service.CurrencyService;
import com.currency.app.utilities.CurrencyResponse;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyService service;

	@GetMapping("/welcome")
	public String getWelcome() {
		return "Welcome to Currency world!!!";
	}

	/**
	 * @param entity
	 * @return
	 */
	@PostMapping("/addNewCurrency")
	public CurrencyResponse createNewCurrency(@RequestBody CurrencyEntity entity) {
		CurrencyResponse response = null;
		if (entity != null) {
			response = service.createNewCurrency(entity);
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @param desc
	 * @return
	 */
	@PutMapping("/updateCurrency")
	public CurrencyResponse updateCurrency(@RequestParam("currencyCode") String currencyCode,
			@RequestParam("amount") Double amount, @RequestParam("desc") String desc) {
		CurrencyResponse response = null;
		if (currencyCode != null && amount != null) {
			response = service.updateCurrency(currencyCode, amount, desc);
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @return
	 */
	@GetMapping("/getCurrency")
	public CurrencyResponse getCurrency(@RequestParam("currencyCode") String currencyCode,
			@RequestParam("amount") Double amount) {
		CurrencyResponse response = null;
		if (currencyCode != null && amount != null) {
			response = service.getCurrency(currencyCode, amount);
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @return
	 */
	@DeleteMapping("/deleteCurrency")
	public CurrencyResponse deleteCurrency(@RequestParam("currencyCode") String currencyCode,
			@RequestParam("amount") Double amount) {
		CurrencyResponse response = null;
		if (currencyCode != null && amount != null) {
			response = service.deleteCurrency(currencyCode, amount);
		}
		return response;
	}

	/**
	 * @param allcurrency
	 * @return
	 */
	@PostMapping("/loadAllCurrency")
	public CurrencyResponse loadAllCurrency(@RequestBody List<CurrencyEntity> allcurrency) {
		CurrencyResponse response = null;
		response = service.loadAllCurrency(allcurrency);
		return response;
	}
	
	/**
	 * @param currencyCode
	 * @return
	 */
	@GetMapping("/getCurrencyBasedOnCurrencyCode")
	public CurrencyResponse getCurrencyBasedOnCurrencyCode(@RequestParam("currencyCode") String currencyCode) {
		CurrencyResponse response = null;
		if (currencyCode != null) {
			response = service.getCurrency(currencyCode);
		}
		return response;
	}

}
