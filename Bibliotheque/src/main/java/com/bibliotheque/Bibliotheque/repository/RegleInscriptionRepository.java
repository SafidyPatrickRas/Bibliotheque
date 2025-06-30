package com.bibliotheque.Bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.Bibliotheque.model.Profil;
import com.bibliotheque.Bibliotheque.model.RegleInscription;

public interface RegleInscriptionRepository extends JpaRepository<RegleInscription, Long> {

    Optional<RegleInscription> findByProfil(Profil profil);
}