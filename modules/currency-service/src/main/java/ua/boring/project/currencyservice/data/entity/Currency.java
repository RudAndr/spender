package ua.boring.project.currencyservice.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Currency {

    private Long id;
    private String currencyName;
    private BigDecimal currencyValue;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
