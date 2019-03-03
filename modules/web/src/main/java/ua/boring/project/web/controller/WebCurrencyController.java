package ua.boring.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/update")
    public HttpStatus updateCurrenciesTable() {
        Integer internalStatus = webCurrencyService.updateCurrencyRates();

        if (internalStatus == 0) {
            return HttpStatus.ACCEPTED;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
