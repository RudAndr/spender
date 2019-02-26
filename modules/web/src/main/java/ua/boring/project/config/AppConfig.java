package ua.boring.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import ua.boring.project.data.entity.User;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Configuration
public class AppConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.setResourceMappingForDomainType(User.class)
                .addResourceMappingFor("ID")
                .setPath("userID");
    }
}
