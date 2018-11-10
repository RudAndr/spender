package ua.boring.project.service;

import ua.boring.project.data.dto.PaymentDto;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.data.entity.User;

import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */
public interface PaymentService {

    void makePayment(User user, PaymentDto paymentDto);
    Optional<Payment> getPayment(long id);

}
