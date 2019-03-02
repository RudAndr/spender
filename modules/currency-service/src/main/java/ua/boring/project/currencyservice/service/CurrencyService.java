package ua.boring.project.currencyservice.service;

import ua.boring.project.currencyservice.data.entity.Currency;

public interface CurrencyService {

    Currency getCurrencyByName(String currencyName);

    Integer createCurrency();

    Integer removeLast();
}
