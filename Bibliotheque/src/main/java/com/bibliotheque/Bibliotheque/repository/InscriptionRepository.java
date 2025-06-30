package com.bibliotheque.Bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.Bibliotheque.model.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}

