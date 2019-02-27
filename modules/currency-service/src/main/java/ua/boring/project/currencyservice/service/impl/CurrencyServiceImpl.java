package ua.boring.project.currencyservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.boring.project.currencyservice.service.CurrencyService;
import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.data.repository.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        return currencyRepository.getCurrencyByCurrencyName(currencyName);
    }

}
