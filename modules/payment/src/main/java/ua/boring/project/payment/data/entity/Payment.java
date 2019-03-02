package ua.boring.project.payment.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String description;

    private BigDecimal balance;
}
