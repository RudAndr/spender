package ua.boring.project.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistrationApplication {

    public static void main(String[] args) {
        System.getProperty("spring.config.name", "application");

        SpringApplication.run(RegistrationApplication.class, args);
    }

}
