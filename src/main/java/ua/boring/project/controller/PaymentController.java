package ua.boring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.boring.project.data.dto.PaymentDto;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.service.PaymentService;

import java.util.List;
import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    static PaymentService paymentService;

    @GetMapping(value = "/find/{id}", headers = {"Accept=applications/json"})
    public ResponseEntity<Payment> getPayment(@PathVariable("id") long id) {
        Optional<Payment> payment = paymentService.getPayment(id);

        if (!payment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/create", headers = {"Accept=applications/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long makePayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.createPayment(paymentDto);
    }

    @GetMapping(value = "/find/all/{userId}", headers = {"Accept=application/json"})
    private ResponseEntity<List<Payment>> getAllUserPayments(@PathVariable("userID") long userId) {
        Optional<List<Payment>> optionalPayments = paymentService.getUserPaymentList(userId);

        return optionalPayments.map(payments -> new ResponseEntity<>(payments, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
