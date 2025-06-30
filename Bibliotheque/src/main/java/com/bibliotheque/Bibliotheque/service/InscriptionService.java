package com.bibliotheque.Bibliotheque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bibliotheque.Bibliotheque.model.Adherant;
import com.bibliotheque.Bibliotheque.model.Inscription;
import com.bibliotheque.Bibliotheque.model.Profil;
import com.bibliotheque.Bibliotheque.model.RegleInscription;
import com.bibliotheque.Bibliotheque.repository.InscriptionRepository;

public class InscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    RegleInscriptionService regleInscriptionService;

    @Autowired
    ProfilService profilService;

    @Autowired
    AdherantService adherantService;

    public void inscription(Inscription inscription){
        // Axistence adherant
        Adherant ad = adherantService.getById(inscription.getAdherant().getId());

        if(ad!=null){
            System.out.println("adherant existant");
        }else{
            System.out.println("adherant non existant");
        }

        // Existence regle inscription de son profil 

        // recuperation des regles utils (nombre validite , prix)

        // creation de la date de fin d inscription

        // insertion


    }
}
