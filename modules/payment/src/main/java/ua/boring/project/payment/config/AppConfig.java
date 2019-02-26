package ua.boring.project.payment.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EntityScan("ua.boring.project.payment.data.entity")
@EnableJpaRepositories("ua.boring.project.payment.data.repository")
public class AppConfig {


}
