package ua.boring.project.currencyservice.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.boring.project.currencyservice.config.CommonTest;
import ua.boring.project.currencyservice.data.entity.Currency;
import ua.boring.project.currencyservice.data.entity.CurrencyList;
import ua.boring.project.currencyservice.service.impl.CurrencyServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CurrencyControllerTest extends CommonTest {

    private CurrencyController currencyController;

    @Mock
    private CurrencyServiceImpl currencyService;

    private MockMvc mockMvc;

    @Override
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        currencyController = new CurrencyController(currencyService);

        mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
    }

    @Test
    public void updateCurrencyTableTest() throws Exception {

        Currency currency = new Currency();
        currency.setCurrencyId(123L);
        currency.setDate(new Date());
        currency.setBase("EUR");

        when(currencyService.updateCurrency()).thenReturn(currency);

        mockMvc.perform(get("/currency/update")).andExpect(status().isOk());
    }

}
