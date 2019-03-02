package ua.boring.project.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.boring.project.web.config.ServiceList;
import ua.boring.project.web.service.WebCurrencyService;

import java.math.BigDecimal;

@Slf4j
@Service
public class WebCurrencyServiceImpl implements WebCurrencyService {

    private static final String SERVICE_URL = ServiceList.RATE_SERVICE.getServiceName();

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Override
    public BigDecimal findCurrencyRateByCode(String currencyCode, BigDecimal eurMoney) {
        return restTemplate.getForObject(SERVICE_URL + "/currency/calc?currencyCode={currencyCode}&eurMoney={eurMoney}", BigDecimal.class, currencyCode, eurMoney);
    }

}
