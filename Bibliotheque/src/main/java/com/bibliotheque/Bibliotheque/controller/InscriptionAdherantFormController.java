package com.bibliotheque.Bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bibliotheque.Bibliotheque.model.Adherant;
import com.bibliotheque.Bibliotheque.model.Authentification;
import com.bibliotheque.Bibliotheque.model.InscriptionAdherantForm;
import com.bibliotheque.Bibliotheque.service.AdherantService;
import com.bibliotheque.Bibliotheque.service.AuthentificationService;
import com.bibliotheque.Bibliotheque.service.InscriptionAdherantFormService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/adherant")
public class InscriptionAdherantFormController {

    @Autowired
    InscriptionAdherantFormService inscriptionAdherantFormService;

    @Autowired
    AuthentificationService authentificationService;

    @Autowired
    AdherantService adherantService;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("authentification", new Authentification());
        model.addAttribute("page", "adherant/login");
        return "template";
    }

    @PostMapping("/login")
    public String traitementLogin(@Valid @ModelAttribute Authentification authentification, BindingResult result, Model model , RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            model.addAttribute("page", "adherant/login");
            return "template";
        }

        if(authentificationService.existsByEmail(authentification.getEmail())){
            Authentification auth_base = authentificationService.getByEmail(authentification.getEmail());
            if(auth_base.getMot_de_passe().equals(authentification.getMot_de_passe())){
                Adherant adherant_log = adherantService.findByAuthentificationId(auth_base.getId());
                
                if(adherant_log!=null){
                    redirectAttributes.addFlashAttribute("success", "Login reussi");
                    System.out.println("Login reussi");
                }else{
                    // Aucun adherant correspondant
                    redirectAttributes.addFlashAttribute("error", "Erreur : Aucun adherant correspondant");
                    System.out.println("Erreur : Aucun adherant correspondant");
                }
            }else{
                // Trouver l existance dans la table auth
                redirectAttributes.addFlashAttribute("error", "Erreur : mot de passe incorect");
                System.out.println("Erreur : mot de passe incorect");
            }   
        }else{
            // Email non correct , non exitant dans la base
            redirectAttributes.addFlashAttribute("error", "Erreur : email innexistante");
            System.out.println("Erreur : email innexistante");
        }

        return "redirect:/adherant/login";
    }

    @GetMapping("/inscription")
    public String formulaire(Model model) {
        model.addAttribute("inscriptionAdherantForm", new InscriptionAdherantForm());
        model.addAttribute("page", "adherant/inscription");
        return "template";
    }



    @PostMapping("/inscription")
    public String traiterInscription(@ModelAttribute("inscriptionAdherantForm") @Valid InscriptionAdherantForm form,
        BindingResult result,
        RedirectAttributes redirectAttributes , Model model) {

        if (result.hasErrors()) {
            model.addAttribute("page", "adherant/inscription");
            return "template"; // formulaire avec erreurs
        }

        try {
            inscriptionAdherantFormService.inscrire(form);
            redirectAttributes.addFlashAttribute("success", "Inscription réussie !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
        }

        return "redirect:/adherant/inscription";
    }
}
