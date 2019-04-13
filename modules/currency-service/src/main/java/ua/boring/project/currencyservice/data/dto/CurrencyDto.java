package ua.boring.project.currencyservice.data.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

@Data
public class CurrencyDto implements Serializable {

    private static final long serialVersionUID = 3470752104945002548L;

    private String base;

    private Date date;

    private HashMap<String, BigDecimal> rates;

}
