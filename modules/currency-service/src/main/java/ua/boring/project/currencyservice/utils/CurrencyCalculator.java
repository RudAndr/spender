package ua.boring.project.currencyservice.utils;

import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.data.entity.CurrencyList;

import java.math.BigDecimal;
import java.util.Optional;

public class CurrencyCalculator {

    public static BigDecimal calculatePrice(String expectedCurrency, BigDecimal eurMoney, Currency currentCurrency) {

        Optional<CurrencyList> currencyList = currentCurrency.getRates()
                                                             .stream()
                                                             .filter(currency ->
                                                                     currency.getCurrencyKey()
                                                                             .equals(expectedCurrency))
                                                             .findFirst();

        if (currencyList.isPresent()) {
            BigDecimal currencyEurPrice = currencyList.get().getCurrencyValue();

            return currencyEurPrice.multiply(eurMoney);
        }

        return eurMoney;
    }

}
