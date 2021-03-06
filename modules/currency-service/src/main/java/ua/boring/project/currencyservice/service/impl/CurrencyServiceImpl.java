package ua.boring.project.currencyservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.boring.project.currencyservice.data.dto.CurrencyDto;
import ua.boring.project.commons.data.CurrencyResult;
import ua.boring.project.currencyservice.data.entity.CurrencyList;
import ua.boring.project.currencyservice.data.repository.CurrencyListRepository;
import ua.boring.project.currencyservice.utils.CurrencyCalculator;
import ua.boring.project.currencyservice.utils.CurrencyParser;
import ua.boring.project.currencyservice.service.CurrencyService;
import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.data.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyListRepository currencyListRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository,
                               CurrencyListRepository currencyListRepository) {
        this.currencyRepository = currencyRepository;
        this.currencyListRepository = currencyListRepository;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        return currencyRepository.getCurrencyByBase(currencyName);
    }

    @Override
    public CurrencyResult calculateCurrency(String expectedCurrency, BigDecimal eurMoney) {
        Currency currency = getLast();

        BigDecimal parsedPrice = CurrencyCalculator.calculatePrice(expectedCurrency, eurMoney, currency);

        return new CurrencyResult(expectedCurrency, parsedPrice);
    }

    @Override
    public Currency updateCurrency() {
        Currency result;

        int removeStatus = removeLast();

        if (removeStatus == -1) {
            return null;
        }

        try {
            CurrencyDto currencyData = CurrencyParser.getCurrencies();

            Currency currency = new Currency();
            currency.setBase(currencyData.getBase());
            currency.setDate(currencyData.getDate());

            List<CurrencyList> currencyLists = new ArrayList<>();
            result = currencyRepository.save(currency);


            for (Map.Entry<String, BigDecimal> entry : currencyData.getRates().entrySet()) {

                CurrencyList currencyList = new CurrencyList();
                currencyList.setCurrencyKey(entry.getKey());
                currencyList.setCurrencyValue(entry.getValue());
                currencyList.setCurrency(result);

                currencyLists.add(currencyList);
            }

            currencyListRepository.saveAll(currencyLists);

        } catch (Exception e) {
            log.debug("Exception while saving new currencies: ", e);

            return null;
        }

        return result;
    }

    @Override
    public Currency getLast() {
        return currencyRepository.findTopByOrderByCurrencyIdDesc();
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
