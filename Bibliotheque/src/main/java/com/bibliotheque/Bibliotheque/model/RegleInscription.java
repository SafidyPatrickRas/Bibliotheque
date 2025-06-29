package com.bibliotheque.Bibliotheque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RegleInscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nbrValidite;

    @OneToOne
    @JoinColumn(name = "profil_id", referencedColumnName = "id", unique = true, nullable = false)
    private Profil profil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrValidite() {
        return nbrValidite;
    }

    public void setNbrValidite(int nbrValidite) {
        this.nbrValidite = nbrValidite;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    
}
