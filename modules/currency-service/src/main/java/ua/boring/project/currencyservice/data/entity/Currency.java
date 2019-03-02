package ua.boring.project.currencyservice.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    private String base;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private HashMap<String, BigDecimal> rates;

}
