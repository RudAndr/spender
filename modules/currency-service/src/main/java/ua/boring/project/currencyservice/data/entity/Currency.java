package ua.boring.project.currencyservice.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
public class Currency {

    private Long id;

    private String base;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private HashMap<String, BigDecimal> rates;

}
