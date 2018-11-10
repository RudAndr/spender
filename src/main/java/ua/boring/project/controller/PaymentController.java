package ua.boring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.service.PaymentService;

import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/{id}", headers = {"Accept=applications/json"})
    public ResponseEntity<Payment> getPayment(@PathVariable("id") long id) {
        Optional<Payment> payment = paymentService.getPayment(id);

        if (!payment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
