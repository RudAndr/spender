package ua.boring.project.web.service;

import ua.boring.project.web.data.CurrencyDto;

import java.math.BigDecimal;

public interface WebCurrencyService {

    BigDecimal findCurrencyRateByCode(String currencyCode, BigDecimal eurMoney);

    CurrencyDto updateCurrencyRates();
}
