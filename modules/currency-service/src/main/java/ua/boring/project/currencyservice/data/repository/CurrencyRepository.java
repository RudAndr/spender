package ua.boring.project.currencyservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.boring.project.currencyservice.data.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency getCurrencyByCurrencyName(String currencyName);

}
