package ua.boring.project.web.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class CurrencyDto {

    private String base;
    private Date date;
    private HashMap<String, BigDecimal> rates;

}
