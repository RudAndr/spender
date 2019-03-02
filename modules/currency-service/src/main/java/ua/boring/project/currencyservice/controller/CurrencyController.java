package ua.boring.project.currencyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/currency/calc")
    public BigDecimal calculateCurrency(@RequestParam("currencyCode") String currencyCode,
                                        @RequestParam("eurMoney") BigDecimal eurMoney) {
        return currencyService.calculateCurrency(currencyCode, eurMoney);
    }

}
