package com.currency.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.app.entity.CurrencyEntity;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
	
	List<CurrencyEntity> findByCurrencyCodeOrderByAmountValueDesc(String currencyCode);
	
	CurrencyEntity findByCurrencyCodeAndAmountValue(String currencyCode, Double amountValue);
	
}
