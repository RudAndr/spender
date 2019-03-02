package ua.boring.project.currencyservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.boring.project.currencyservice.parser.CurrencyParser;
import ua.boring.project.currencyservice.service.CurrencyService;
import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.data.repository.CurrencyRepository;

import java.io.IOException;

@Slf4j
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        return currencyRepository.getCurrencyByBase(currencyName);
    }

    @Override
    public Integer createCurrency() {
        int removeStatus = removeLast();

        if (removeStatus == -1) {
            return -1;
        }

        try {
            Currency currency = CurrencyParser.getCurrencies();

            currencyRepository.save(currency);
        } catch (IOException e) {
            log.debug("Exception while saving new currencies: ", e);

            return -1;
        }

        return 0;
    }

    @Override
    public Integer removeLast() {
        try {
            Currency currency = currencyRepository.findTopByOrderByIdDesc();
            currencyRepository.delete(currency);

            return 0;
        } catch (Exception ex) {
            log.debug("Exception while deleting data: ", ex);

            return -1;
        }
    }

}
