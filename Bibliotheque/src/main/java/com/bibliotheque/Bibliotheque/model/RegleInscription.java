package com.bibliotheque.Bibliotheque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class RegleInscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "La durée de validité doit être au minimum de 1")
    private int nbrValidite;

    @OneToOne
    @JoinColumn(name = "profil_id", referencedColumnName = "id", unique = true, nullable = false)
    @NotNull(message = "Le profil est obligatoire")
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
