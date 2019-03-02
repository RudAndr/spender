package ua.boring.project.web.service;

import java.math.BigDecimal;

public interface WebCurrencyService {

    BigDecimal findCurrencyRateByCode(String currencyCode, BigDecimal eurMoney);
}
