package ua.boring.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.boring.project.data.entity.User;

/**
 * @author Rudenko Andrey
 * @project project
 */

public interface UserRepo extends JpaRepository<User, Long> {
}
