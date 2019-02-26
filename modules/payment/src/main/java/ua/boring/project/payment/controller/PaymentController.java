package ua.boring.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.boring.project.payment.data.entity.Payment;
import ua.boring.project.payment.data.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments(@RequestParam("id") long userId) {

        return paymentRepository.findAllByUserId(userId);
    }


}
