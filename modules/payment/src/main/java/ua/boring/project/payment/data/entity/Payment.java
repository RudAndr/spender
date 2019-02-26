package ua.boring.project.payment.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class Payment {

    private long id;

    private long userId;

    private String description;

    private BigDecimal balance;
}
