package ua.boring.project.currencyservice.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import ua.boring.project.currencyservice.data.repository.CurrencyListRepository;
import ua.boring.project.currencyservice.data.repository.CurrencyRepository;
import ua.boring.project.currencyservice.config.CommonTest;

import java.math.BigDecimal;

public class CurrencyServiceImplTest extends CommonTest {

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyListRepository currencyListRepository;

    @Override
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        currencyService = new CurrencyServiceImpl(currencyRepository, currencyListRepository);
    }

    @Test
    public void updateCurrencyTest() {
        Assertions.assertThat(currencyService.updateCurrency()).isNotNull();
    }

    @Test
    public void deleteCurrencyTest() {

        Assertions.assertThat(currencyService.removeLast()).isNotEqualTo(-1);
    }

    @Test
    public void calculateCurrencyTest() {
        String expectedCurrency = "UAH";
        BigDecimal uahMoney = new BigDecimal(26);
        currencyService.updateCurrency();

        Assertions.assertThat(currencyService.calculateCurrency(expectedCurrency, uahMoney)).isNotEqualTo(uahMoney);
    }

}
