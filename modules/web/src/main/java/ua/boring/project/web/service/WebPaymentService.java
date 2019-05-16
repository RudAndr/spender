package ua.boring.project.web.service;

import ua.boring.project.commons.data.PaymentDto;

import java.util.Optional;

public interface WebPaymentService {
    Optional<PaymentDto> makePayment(PaymentDto paymentDto);
}
