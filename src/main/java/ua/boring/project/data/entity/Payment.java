package ua.boring.project.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "PAYMENTS")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PAYMENT_DESCRIPTION")
    private String paymentDescription;

    @Column(name = "COST")
    private BigDecimal cost;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

}
