package com.bibliotheque.Bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.Bibliotheque.model.Adherant;
import com.bibliotheque.Bibliotheque.model.Authentification;
import com.bibliotheque.Bibliotheque.model.InscriptionAdherantForm;

import jakarta.transaction.Transactional;


@Service
public class InscriptionAdherantFormService {

    @Autowired
     private  AuthentificationService authentificationService;
    
    @Autowired
     private  AdherantService adherantService;

    @Transactional
    public void inscrire(InscriptionAdherantForm form) throws Exception {

        if (authentificationService.existsByEmail(form.getEmail())) {
            throw new Exception("Cet email est déjà utilisé.");
        }

        Authentification auth = new Authentification();
        auth.setEmail(form.getEmail());
        auth.setMot_de_passe(form.getMot_de_passe());
        authentificationService.save(auth);

        Adherant adherant = new Adherant();
        adherant.setNom(form.getNom());
        adherant.setPrenom(form.getPrenom());
        adherant.setDateNaissance(form.getDateNaissance());
        adherant.setAuthentification(auth);
        adherantService.save(adherant);
    }
}