package ua.boring.project.currencyservice.service;

import ua.boring.project.currencyservice.data.dto.CurrencyResult;
import ua.boring.project.currencyservice.data.entity.Currency;

import java.math.BigDecimal;

public interface CurrencyService {

    Currency getCurrencyByName(String currencyName);

    CurrencyResult calculateCurrency(String expectedCurrency, BigDecimal eurMoney);

    Currency updateCurrency();

    Currency getLast();

    Integer removeLast();
}
