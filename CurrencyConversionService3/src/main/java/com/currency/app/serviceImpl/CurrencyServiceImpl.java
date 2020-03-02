package com.currency.app.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.app.entity.CurrencyEntity;
import com.currency.app.repo.CurrencyRepository;
import com.currency.app.service.CurrencyService;
import com.currency.app.utilities.AbstractFactory;
import com.currency.app.utilities.CurrencyResponse;
import com.currency.app.utilities.EuroCurrency;
import com.currency.app.utilities.IndianCurrency;
import com.currency.app.utilities.USACurrency;

@Service
public class CurrencyServiceImpl extends AbstractFactory implements CurrencyService {

	private static final Logger log = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Autowired
	private CurrencyRepository repo;

	/**
	 * @param entity
	 * @return
	 */
	public CurrencyResponse createNewCurrency(CurrencyEntity entity) {
		log.info("Inside CurrencyService class, createNewCurrency method");
		CurrencyResponse response = new CurrencyResponse();
		try {
			if (entity.getAmountValue() > 0) {
				CurrencyEntity savedDate = repo.save(entity);
				response.setData(savedDate);
				response.setSuccessMessage("Successfully currency code for " + entity.getCurrencyCode()
						+ " and the amount = " + entity.getAmountValue() + " inserted in the table !");
			} else {
				response.setErrorMessage("Oops ! currency code for " + entity.getCurrencyCode()
						+ " and the amount should be greater than zero.");
			}

		} catch (Exception e) {
			log.error("Exception inside CurrencyService class, createNewCurrency method");
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @param desc
	 * @return
	 */
	public CurrencyResponse updateCurrency(String currencyCode, Double amount, String desc) {
		log.info("Inside CurrencyService class, updateCurrency method");
		CurrencyResponse response = new CurrencyResponse();
		try {
			CurrencyEntity existingCurrency = repo.findByCurrencyCodeAndAmountValue(currencyCode, amount);
			if (existingCurrency != null) {
				if (desc != null) {
					existingCurrency.setCurrencyDesc(desc);
				}
				CurrencyEntity savedDate = repo.save(existingCurrency);
				response.setData(savedDate);
				response.setSuccessMessage("Successfully currency code for " + savedDate.getCurrencyCode()
						+ " and the amount = " + savedDate.getAmountValue() + " updated in the table !");
			} else {
				response.setErrorMessage("Successfully currency code for " + currencyCode + " and the amount = "
						+ amount + " deleted from the table !");
			}

		} catch (Exception e) {
			log.error("Exception inside CurrencyService class, updateCurrency method");
			response.setErrorMessage("There is no currency" + currencyCode + " available in the world ");
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @return
	 */
	public CurrencyResponse getCurrency(String currencyCode, Double amount) {
		log.info("Inside CurrencyService class, getCurrency method");
		CurrencyResponse response = new CurrencyResponse();
		try {
			List<CurrencyEntity> currencyList = repo.findByCurrencyCodeOrderByAmountValueDesc(currencyCode);
			Map<String, Object> responseMap = new LinkedHashMap<>();
			if (currencyCode.equals("INR")) {
				new IndianCurrency().getCurrency(amount, currencyList, responseMap);
			}
			if (currencyCode.equals("USD")) {
				new USACurrency().getCurrency(amount, currencyList, responseMap);
			}
			if (currencyCode.equals("EUR")) {
				new EuroCurrency().getCurrency(amount, currencyList, responseMap);
			}

			response.setData(responseMap);
		} catch (Exception e) {
			log.error("Exception inside CurrencyService class, getCurrency method");
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @return
	 */
	public CurrencyResponse deleteCurrency(String currencyCode, Double amount) {
		log.info("Inside CurrencyService class, deleteCurrency method");
		CurrencyResponse response = new CurrencyResponse();
		try {
			CurrencyEntity existingCurrency = repo.findByCurrencyCodeAndAmountValue(currencyCode, amount);
			if (existingCurrency != null) {
				repo.delete(existingCurrency);
				response.setSuccessMessage("Successfully currency code for " + existingCurrency.getCurrencyCode()
						+ " and the amount = " + existingCurrency.getAmountValue() + " deleted from the table !");
			} else {
				response.setErrorMessage("Successfully currency code for " + currencyCode + " and the amount = "
						+ amount + " deleted from the table !");
			}

		} catch (Exception e) {
			log.error("Exception inside CurrencyService class, deleteCurrency method");
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param loadAllCurrency
	 * @return
	 */
	public CurrencyResponse loadAllCurrency(List<CurrencyEntity> loadAllCurrency) {
		log.info("Inside CurrencyService class, loadAllCurrency method");
		CurrencyResponse response = new CurrencyResponse();
		try {
			List<CurrencyEntity> allRecord = repo.saveAll(loadAllCurrency);
			response.setData(allRecord);
			response.setSuccessMessage("Successfully loaded all currency !");
		} catch (Exception e) {
			log.error("Exception inside CurrencyService class, loadAllCurrency method");
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param currencyCode
	 * @return
	 */
	public CurrencyResponse getCurrency(String currencyCode) {
		log.info("Inside CurrencyService class, updateCurrency method");
		CurrencyResponse response = new CurrencyResponse();
		try {
			List<CurrencyEntity> existingCurrencyList = repo.findByCurrencyCodeOrderByAmountValueDesc(currencyCode);
			if (!existingCurrencyList.isEmpty()) {
				response.setData(existingCurrencyList);
				response.setSuccessMessage("Successfully loaded for the currency code for " + currencyCode + "!");
			} else {
				response.setErrorMessage("There is no currency " + currencyCode + " available in the world ");
			}

		} catch (Exception e) {
			log.error("Exception inside CurrencyService class, updateCurrency method");
			response.setErrorMessage("There is no currency" + currencyCode + " available in the world ");
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public void getCurrency(Double amount, List<CurrencyEntity> currencyList, Map<String, Object> responseMap) {
	}
}
