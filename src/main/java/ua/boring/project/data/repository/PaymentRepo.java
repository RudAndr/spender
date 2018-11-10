package ua.boring.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.boring.project.data.entity.Payment;

/**
 * @author Rudenko Andrey
 * @project project
 */

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
