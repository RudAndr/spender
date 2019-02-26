package ua.boring.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.boring.project.data.entity.Payment;
import ua.boring.project.data.entity.User;

import java.util.List;

/**
 * @author Rudenko Andrey
 * @project project
 */

public interface PaymentRepo extends JpaRepository<Payment, Long> {

    List<Payment> findAllByUser(User user);
}
