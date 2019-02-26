package ua.boring.project.service;

import ua.boring.project.data.dto.PaymentDto;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.data.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */
public interface PaymentService {

    long makePayment(User user, PaymentDto paymentDto);
    Optional<Payment> getPaymentById(long id);
    long createPayment(PaymentDto paymentDto);
    Optional<List<Payment>> getUserPaymentList(long userId);
}
