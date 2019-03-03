package ua.boring.project.currencyservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.boring.project.currencyservice.data.entity.CurrencyList;

public interface CurrencyListRepository extends JpaRepository<CurrencyList, Long> {
}
