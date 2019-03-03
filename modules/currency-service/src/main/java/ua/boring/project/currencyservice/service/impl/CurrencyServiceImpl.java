package ua.boring.project.currencyservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.boring.project.currencyservice.data.dto.CurrencyDto;
import ua.boring.project.currencyservice.data.entity.CurrencyList;
import ua.boring.project.currencyservice.data.repository.CurrencyListRepository;
import ua.boring.project.currencyservice.utils.CurrencyCalculator;
import ua.boring.project.currencyservice.utils.CurrencyParser;
import ua.boring.project.currencyservice.service.CurrencyService;
import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.data.repository.CurrencyRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
//    private final CurrencyListRepository currencyListRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository
//                               CurrencyListRepository currencyListRepository
    ) {
        this.currencyRepository = currencyRepository;
//        this.currencyListRepository = currencyListRepository;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        return currencyRepository.getCurrencyByBase(currencyName);
    }

    @Override
    public BigDecimal calculateCurrency(String expectedCurrency, BigDecimal eurMoney) {
        Currency currency = getLast();

        return CurrencyCalculator.calculatePrice(expectedCurrency, eurMoney, currency);
    }

    @Override
    public Integer updateCurrency() {
        int removeStatus = removeLast();

        if (removeStatus == -1) {
            return -1;
        }

        try {
            Currency currencyData = CurrencyParser.getCurrencies();
//
//            Currency currency = new Currency();
//            currency.setBase(currencyData.getBase());
//            currency.setDate(currencyData.getDate());
//
//            for (Map.Entry<String, BigDecimal> entry : currencyData.getRates().entrySet()) {
//
//                CurrencyList currencyList = new CurrencyList();
//                currencyList.setDate(currencyData.getDate());
//                currencyList.setCurrencyKey(entry.getKey());
//                currencyList.setCurrencyValue(entry.getValue());
//
//                currencyListRepository.save(currencyList);
//            }

            currencyRepository.save(currencyData);
        } catch (Exception e) {
            log.debug("Exception while saving new currencies: ", e);

            return -1;
        }

        return 0;
    }

    @Override
    public Currency getLast() {
        return currencyRepository.findTopByOrderByIdDesc();
    }

    @Override
    public Integer removeLast() {
        try {
            Currency currency = getLast();

            if (currency != null) {
                currencyRepository.delete(currency);
            }

            return 0;
        } catch (Exception ex) {
            log.debug("Exception while deleting data: ", ex);

            return -1;
        }
    }

}
