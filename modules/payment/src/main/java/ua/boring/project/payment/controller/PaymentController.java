package ua.boring.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.boring.project.payment.data.entity.Payment;
import ua.boring.project.payment.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments(@RequestParam("userId") long userId) {

        return paymentService.findAllByUserId(userId);
    }

    @GetMapping("/get")
    public Payment getPaymentById(@RequestParam("paymentId") long paymentId) {
        return paymentService.findById(paymentId);
    }

    @PostMapping("/create")
    public HttpStatus createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }
}
