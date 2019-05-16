package ua.boring.project.currencyservice.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.boring.project.currencyservice.service.CurrencyService;

@Slf4j
@Component
public class CurrencyUpdateScheduler {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyUpdateScheduler(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Scheduled(cron = "* 0 8 * * *")
    public void updateCurrency() {
        log.info("Updating currencies in Database: ");
        currencyService.updateCurrency();
    }

}
