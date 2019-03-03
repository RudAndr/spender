package ua.boring.project.currencyservice.data.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "currency_list")
public class CurrencyList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String currencyKey;

    private BigDecimal currencyValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Currency.class)
    @JoinColumn(name = "currencyId", foreignKey = @ForeignKey(name = "fkdtrjfjp11s6ijxwxlrajuenfr"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Currency currency;

}
