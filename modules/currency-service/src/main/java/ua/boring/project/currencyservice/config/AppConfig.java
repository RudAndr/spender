package ua.boring.project.currencyservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EnableJpaRepositories("ua.boring.project.currencyservice.data.repository")
@EntityScan("ua.boring.project.currencyservice.data.entity")
public class AppConfig {
}
