package com.bibliotheque.Bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.Bibliotheque.model.Authentification;

public interface AuthentificationRepository extends JpaRepository<Authentification, Long> {
    boolean existsByEmail(String email);


    Optional<Authentification> findByEmail(String email);

    
}
