package ua.boring.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.boring.project.web.data.PaymentDto;
import ua.boring.project.web.service.WebPaymentService;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class WebPaymentController {

    private final WebPaymentService webPaymentService;

    @Autowired
    public WebPaymentController(WebPaymentService webPaymentService) {
        this.webPaymentService = webPaymentService;
    }

    @PostMapping("/")
    public ResponseEntity<PaymentDto> makePayment(@RequestBody PaymentDto paymentCriteria) {
        return webPaymentService.makePayment(paymentCriteria)
                                .map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

}
