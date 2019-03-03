package ua.boring.project.currencyservice.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class CurrencyList {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String currencyKey;

    private BigDecimal currencyValue;

}
