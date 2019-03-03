package ua.boring.project.currencyservice.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CurrencyIdGenerator")
    @SequenceGenerator(name = "CurrencyIdGenerator", sequenceName = "SEQ_CURRENCY_ID")
    @Column(name = "currencyId", unique = true, nullable = false)
    private Long currencyId;

    private String base;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CurrencyList> rates;

}
