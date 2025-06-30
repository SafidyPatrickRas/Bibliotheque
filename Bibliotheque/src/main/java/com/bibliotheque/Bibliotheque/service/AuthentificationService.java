package com.bibliotheque.Bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.Bibliotheque.model.Authentification;
import com.bibliotheque.Bibliotheque.repository.AuthentificationRepository;

@Service
public class AuthentificationService {
    @Autowired
    private AuthentificationRepository authentificationRepository;

    public List<Authentification> getAll() {
        return authentificationRepository.findAll();
    }

    public void save(Authentification authentification) {
        authentificationRepository.save(authentification);
    }

    public Authentification getById(Long id) {
        return authentificationRepository.findById(id).orElse(null);
    }

    public Authentification getByEmail(String email){
        return authentificationRepository.findByEmail(email).orElse(null);
    }

    public void delete(Long id) {
        authentificationRepository.deleteById(id);
    }

    public boolean existsByEmail(String email){
        return authentificationRepository.existsByEmail(email);
    }
}
