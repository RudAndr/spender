package ua.boring.project.web.data;

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
