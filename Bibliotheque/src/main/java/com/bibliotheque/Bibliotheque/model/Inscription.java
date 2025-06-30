package com.bibliotheque.Bibliotheque.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Past(message = "Date invalide")
    private LocalDate date_inscription;

    @NotNull(message = "Date de fin d inscription obligatoire")
    private LocalDate date_fin_inscription;

    @NotNull(message = "Le prix est obligatoire")
    @DecimalMin(value = "0.01", message = "Le prix doit être supérieur à 0")
    private Double prix;

    @OneToOne
    @JoinColumn(name = "adherant_id", referencedColumnName = "id", unique = true, nullable = false)
    @NotNull(message = "L' adherant est obligatoire")
    private Adherant adherant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate date_inscription) {
        this.date_inscription = date_inscription;
    }

    public LocalDate getDate_fin_inscription() {
        return date_fin_inscription;
    }

    public void setDate_fin_inscription(LocalDate date_fin_inscription) {
        this.date_fin_inscription = date_fin_inscription;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Adherant getAdherant() {
        return adherant;
    }

    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }

    
}
