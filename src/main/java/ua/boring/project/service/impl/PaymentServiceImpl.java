package ua.boring.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.boring.project.data.dto.PaymentDto;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.data.entity.User;
import ua.boring.project.data.repository.PaymentRepo;
import ua.boring.project.service.PaymentService;

import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    static PaymentRepo paymentRepository;

    @Override
    public void makePayment(User user, PaymentDto paymentDto) {

    }

    @Override
    public Optional<Payment> getPayment(long id) {
        return paymentRepository.findById(id);
    }
}
