package ua.boring.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.boring.project.web.service.WebCurrencyService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
public class WebCurrencyController {

    private final WebCurrencyService webCurrencyService;

    @Autowired
    public WebCurrencyController(WebCurrencyService webCurrencyService) {
        this.webCurrencyService = webCurrencyService;
    }

    @GetMapping("/calculate")
    public BigDecimal calculateCurrency(@RequestParam("currencyCode") String currencyCode,
                                        @RequestParam("eurMoney") BigDecimal eurMoney) {
        return webCurrencyService.findCurrencyRateByCode(currencyCode, eurMoney);
    }

}
