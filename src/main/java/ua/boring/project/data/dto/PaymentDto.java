package ua.boring.project.data.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Rudenko Andrey
 * @project project
 */

@EqualsAndHashCode
@Getter
@Setter
public class PaymentDto {

    private BigDecimal cost;
    private String paymentDescription;
    private Long userId;
}
