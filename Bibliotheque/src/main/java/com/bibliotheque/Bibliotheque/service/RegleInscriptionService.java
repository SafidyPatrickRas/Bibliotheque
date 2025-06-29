package com.bibliotheque.Bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.Bibliotheque.model.RegleInscription;
import com.bibliotheque.Bibliotheque.repository.RegleInscriptionRepository;

@Service
public class RegleInscriptionService {

    @Autowired
    private RegleInscriptionRepository regleInscriptionRepository;

    public List<RegleInscription> getAll() {
        return regleInscriptionRepository.findAll();
    }

    public void save(RegleInscription regleInscription) throws Exception{

        if (regleInscriptionRepository.findByProfil(regleInscription.getProfil()).isPresent()) {
            throw new Exception("Ce profil a déjà une règle d'inscription.");
        }

        try {
            regleInscriptionRepository.save(regleInscription);
        } catch (Exception e) {
            throw new Exception("Erreur lors de l'enregistrement : " + e.getMessage());
        }

    }
    public void update(RegleInscription regleInscription){
        regleInscriptionRepository.save(regleInscription);
    }

    public RegleInscription getById(Long id) {
        return regleInscriptionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        regleInscriptionRepository.deleteById(id);
    }
}
