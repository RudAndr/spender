package ua.boring.project.currencyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.boring.project.commons.data.CurrencyResult;
import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.service.CurrencyService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/calc")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyResult calculateCurrency(@RequestParam("currencyCode") String currencyCode,
                                            @RequestParam("eurMoney") String eurMoney) {
        return currencyService.calculateCurrency(currencyCode, new BigDecimal(eurMoney));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Currency updateCurrencyTable() {

        return currencyService.updateCurrency();
    }

}
