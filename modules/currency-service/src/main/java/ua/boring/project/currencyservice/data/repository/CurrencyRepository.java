package ua.boring.project.currencyservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.boring.project.currencyservice.data.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency getCurrencyByBase(String currencyName);

    Currency findTopByOrderByCurrencyIdDesc();

}
