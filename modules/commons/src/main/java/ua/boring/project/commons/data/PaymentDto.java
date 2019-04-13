package ua.boring.project.commons.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDto {

    private Long userId;
    private String description;
    private BigDecimal balance;

}
