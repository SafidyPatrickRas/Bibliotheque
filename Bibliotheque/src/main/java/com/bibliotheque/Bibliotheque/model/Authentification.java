package com.bibliotheque.Bibliotheque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Authentification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;


    @NotBlank(message = "Le mot de passe est obligatoire")
    @Min(value = 6, message = "Le mot de passe doit être au minimum de 6")
    private String mot_de_passe;

    @Email
    @NotBlank(message = "L email est obligatoire")
    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
