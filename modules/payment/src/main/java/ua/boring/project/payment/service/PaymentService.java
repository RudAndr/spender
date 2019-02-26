package ua.boring.project.payment.service;

import ua.boring.project.payment.data.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAllByUserId(long userId);

    Payment findById(long id);
}
