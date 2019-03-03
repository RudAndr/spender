package ua.boring.project.rateservice.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.boring.project.currencyservice.data.repository.CurrencyRepository;
import ua.boring.project.currencyservice.service.impl.CurrencyServiceImpl;
import ua.boring.project.rateservice.config.BaseTestConfig;

public class CurrencyServiceImplTest extends BaseTestConfig {

    private CurrencyServiceImpl currencyService;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        currencyService = new CurrencyServiceImpl(currencyRepository);
    }

    @Test
    public void updateCurrencyTest() {
        Assertions.assertThat(currencyService.updateCurrency()).isNotNull();
    }

}
