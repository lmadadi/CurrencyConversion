/**
 * 
 */
package com.currency.app.CurrencyConversionService3;

import java.io.File;
import java.io.IOException;

import com.currency.app.entity.CurrencyEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        CurrencyEntity currencyEntity = createCurrencyEntity();

        try {

            mapper.writeValue(new File("C:/Temp-Work/currencyEntity.json"), currencyEntity);
            String jsonString = mapper.writeValueAsString(currencyEntity);
            System.out.println(jsonString);

            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currencyEntity);
            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CurrencyEntity createCurrencyEntity() {

    	CurrencyEntity currencyEntity = new CurrencyEntity();
    	currencyEntity.setAmountValue(null);
    	currencyEntity.setConvertionRate(null);
    	currencyEntity.setCurrencyCode(null);
    	currencyEntity.setCurrencyId(null);
    	currencyEntity.setCurrencyDesc(null);
        return currencyEntity;

    }

}
