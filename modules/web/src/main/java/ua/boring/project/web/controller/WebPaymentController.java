package ua.boring.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/create")
    public String makePayment(@RequestBody PaymentDto paymentCriteria) {
        Optional<PaymentDto> paymentDto = webPaymentService.makePayment(paymentCriteria);

        if (paymentDto.isPresent()) {
            return HttpStatus.CREATED.toString();
        }

        return HttpStatus.EXPECTATION_FAILED.toString();
    }

}
