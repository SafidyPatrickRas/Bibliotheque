package com.bibliotheque.Bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.Bibliotheque.model.Adherant;

public interface AdherantRepository extends JpaRepository<Adherant, Long> {

    @Query("SELECT a FROM Adherant a WHERE a.authentification.id = :id")
    Optional<Adherant> findByAuthentificationId(@Param("id") Long id);

}
