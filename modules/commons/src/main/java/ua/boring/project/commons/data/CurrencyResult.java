package ua.boring.project.commons.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResult implements Serializable {

    private static final long serialVersionUID = -4297050857153921103L;

    private String currencyName;
    private BigDecimal currencyValue;
}
