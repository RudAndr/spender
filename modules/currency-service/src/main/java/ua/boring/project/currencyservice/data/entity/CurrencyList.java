package ua.boring.project.currencyservice.data.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "currency_list")
public class CurrencyList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CurrencyListIdGenerator")
    @SequenceGenerator(name = "CurrencyListIdGenerator", sequenceName = "SEQ_CURRENCY_LIST_ID")
    private Long id;

    private String currencyKey;

    private BigDecimal currencyValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Currency.class)
    @JoinColumn(name = "currencyId", foreignKey = @ForeignKey(name = "fkdtrjfjp11s6ijxwxlrajuenfr"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Currency currency;

    @Override
    public String toString() {
        return "CurrencyList{" +
                "id=" + id +
                ", currencyKey='" + currencyKey + '\'' +
                ", currencyValue=" + currencyValue +
                ", currency=" + currency.getCurrencyId() +
                '}';
    }
}
