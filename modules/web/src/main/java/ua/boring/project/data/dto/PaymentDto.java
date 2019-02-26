package ua.boring.project.data.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Data
public class PaymentDto {

    private BigDecimal cost;
    private String paymentDescription;
    private Long userId;
}
