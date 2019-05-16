package ua.boring.project.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.boring.project.commons.data.PaymentDto;
import ua.boring.project.web.config.ServiceList;
import ua.boring.project.web.service.WebPaymentService;

import java.util.Optional;

@Slf4j
@Service
public class WebPaymentServiceImpl implements WebPaymentService {

    private static final String SERVICE_URL = ServiceList.PAYMENT_SERVICE.getServiceName();

    private final RestTemplate restTemplate;

    @Autowired
    public WebPaymentServiceImpl(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<PaymentDto> makePayment(PaymentDto paymentDto) {
        return Optional.ofNullable(restTemplate.postForObject(SERVICE_URL + "/create", paymentDto, PaymentDto.class));
    }

}
