package ua.boring.project.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.boring.project.payment.data.entity.Payment;
import ua.boring.project.payment.data.repository.PaymentRepository;
import ua.boring.project.payment.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAllByUserId(long userId) {
        return paymentRepository.findAllByUserId(userId);
    }

    @Override
    public Payment findById(long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        return optionalPayment.orElse(null);

    }
}