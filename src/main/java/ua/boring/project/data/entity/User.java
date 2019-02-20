package ua.boring.project.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rudenko Andrey
 * @project project
 */

@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Payment> payments;
}
