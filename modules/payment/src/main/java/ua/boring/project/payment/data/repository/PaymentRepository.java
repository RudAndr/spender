package ua.boring.project.payment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.boring.project.payment.data.entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByUserId(long userId);

}
