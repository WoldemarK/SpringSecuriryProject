package com.example.SpringSecuriryProject.repository;

import com.example.SpringSecuriryProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findByName(String username);
}