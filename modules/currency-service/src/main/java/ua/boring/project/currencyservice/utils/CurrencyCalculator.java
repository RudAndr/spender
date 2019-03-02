package ua.boring.project.currencyservice.utils;

import ua.boring.project.currencyservice.data.entity.Currency;

import java.math.BigDecimal;

public class CurrencyCalculator {

    public static BigDecimal calculatePrice(String expectedCurrency, BigDecimal eurMoney, Currency currentCurrency) {

        BigDecimal currencyEurPrice = currentCurrency.getRates().get(expectedCurrency);
        return currencyEurPrice.multiply(eurMoney);
    }

}
