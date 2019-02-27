package ua.boring.project.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.boring.project.data.dto.PaymentDto;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.data.entity.User;

import ua.boring.project.service.PaymentService;
import ua.boring.project.utils.ActiveServices;

import java.util.List;
import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    private final RestTemplate restTemplate;
    private String serviceUrl;

    @Autowired
    public PaymentServiceImpl(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.serviceUrl = "http://" + ActiveServices.PAYMENT_SERVICE.getStringValue();
    }

    @Override
    public long makePayment(User user, PaymentDto paymentDto) {
        return 0;
    }

    @Override
    public Optional<Payment> getPaymentById(long id) {
        return Optional.empty();
    }

    @Override
    public long createPayment(PaymentDto paymentDto) {
        return 0;
    }

    @Override
    public Optional<List<Payment>> getUserPaymentList(long userId) {
        return Optional.empty();
    }
}
