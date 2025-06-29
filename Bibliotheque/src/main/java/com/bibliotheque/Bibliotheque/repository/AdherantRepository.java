package com.bibliotheque.Bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.Bibliotheque.model.Adherant;

public interface AdherantRepository extends JpaRepository<Adherant, Long> {
}
