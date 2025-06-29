package com.bibliotheque.Bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.Bibliotheque.model.Adherant;
import com.bibliotheque.Bibliotheque.repository.AdherantRepository;

@Service
public class AdherantService {

    @Autowired
    private AdherantRepository adherantRepository;

    public List<Adherant> getAll() {
        return adherantRepository.findAll();
    }

    public void save(Adherant adherant) {
        adherantRepository.save(adherant);
    }

    public Adherant getById(Long id) {
        return adherantRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        adherantRepository.deleteById(id);
    }
}
