package com.example.SpringSecuriryProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "year_of_birth")
    private int birth;

    @Column(name = "role")
    private String role;

    public User(String username, String password, int birth) {
        this.username = username;
        this.password = password;
        this.birth = birth;
    }

    public User() {
    }

}
