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

import com.bibliotheque.Bibliotheque.model.InscriptionAdherantForm;
import com.bibliotheque.Bibliotheque.service.InscriptionAdherantFormService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/adherant/inscription")
public class InscriptionAdherantFormController {

    @Autowired
    InscriptionAdherantFormService inscriptionAdherantFormService;

    @GetMapping
    public String formulaire(Model model) {
        model.addAttribute("inscriptionAdherantForm", new InscriptionAdherantForm());
        model.addAttribute("page", "adherant/inscription");
        return "template";
    }


    @PostMapping
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
