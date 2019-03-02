package ua.boring.project.currencyservice.service;

import ua.boring.project.currencyservice.data.entity.Currency;

import java.math.BigDecimal;

public interface CurrencyService {

    Currency getCurrencyByName(String currencyName);

    BigDecimal calculateCurrency(String expectedCurrency, BigDecimal eurMoney);

    Integer updateCurrency();

    Currency getLast();

    Integer removeLast();
}
