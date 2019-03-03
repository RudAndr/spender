package ua.boring.project.currencyservice.data.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

@Data
public class CurrencyDto {

    private String base;

    private Date date;

    private HashMap<String, BigDecimal> rates;

}
