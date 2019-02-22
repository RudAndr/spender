package ua.boring.project.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.boring.project.data.dto.PaymentDto;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.data.entity.User;
import ua.boring.project.data.repository.PaymentRepo;
import ua.boring.project.data.repository.UserRepo;
import ua.boring.project.service.PaymentService;
import ua.boring.project.utils.DateUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Slf4j
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepository;

    private final UserRepo userRepo;

    @Autowired
    public PaymentServiceImpl(PaymentRepo paymentRepository, UserRepo userRepo) {
        this.paymentRepository = paymentRepository;
        this.userRepo = userRepo;
    }

    @Override
    public long makePayment(User user, PaymentDto paymentDto) {
        if (user == null) {
            log.info("User is not present id DB");
            return -1;
        }

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setPaymentDate(DateUtils.getCurrentSqlDate());
        payment.setPaymentDescription(paymentDto.getPaymentDescription());
        payment.setCost(paymentDto.getCost());

        return paymentRepository.saveAndFlush(payment).getId();
    }

    @Override
    public Optional<Payment> getPayment(long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public long createPayment(PaymentDto paymentDto) {
        Optional<User> currentUser = userRepo.findById(paymentDto.getUserId());

        if (!currentUser.isPresent()) {
            log.warn("User is null");
            return -1;
        }

        return this.makePayment(currentUser.get(), paymentDto);
    }

    @Override
    public Optional<List<Payment>> getUserPaymentList(long userId) {
        Optional<User> user = userRepo.findById(userId);

        if (!user.isPresent()) {
            log.warn("User is absent!");
            return Optional.empty();
        }

        return Optional.ofNullable(paymentRepository.findAllByUser(user.get()));
    }


}
