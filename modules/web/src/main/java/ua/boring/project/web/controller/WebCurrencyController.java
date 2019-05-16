package ua.boring.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.boring.project.commons.data.CurrencyResult;
import ua.boring.project.web.data.CurrencyDto;
import ua.boring.project.web.service.WebCurrencyService;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/currency")
public class WebCurrencyController {

    private final WebCurrencyService webCurrencyService;

    @Autowired
    public WebCurrencyController(WebCurrencyService webCurrencyService) {
        this.webCurrencyService = webCurrencyService;
    }

    @GetMapping("/calculate")
    public CurrencyResult calculateCurrency(@RequestParam("currencyCode") String currencyCode,
                                            @RequestParam("eurMoney") BigDecimal eurMoney) {
        return webCurrencyService.findCurrencyRateByCode(currencyCode, eurMoney);
    }

    /** manual updating currency base
     * APP-ADMIN only
     *
     **/

    //todo APP-ADMIN ROLE
    //todo: TEST IT AS SOON AS POSSIBLE
    @GetMapping("/update")
    public ResponseEntity<CurrencyDto> updateCurrenciesTable() {
        return Optional.ofNullable(webCurrencyService.updateCurrencyRates())
                       .map(currencyDto -> new ResponseEntity<>(currencyDto, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
