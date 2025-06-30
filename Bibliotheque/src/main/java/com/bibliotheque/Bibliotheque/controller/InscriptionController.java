package com.bibliotheque.Bibliotheque.controller;

import com.bibliotheque.Bibliotheque.service.AdherantService;
import com.bibliotheque.Bibliotheque.service.InscriptionService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import com.bibliotheque.Bibliotheque.model.Adherant;
import com.bibliotheque.Bibliotheque.model.Inscription;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;

    @Autowired
    AdherantService adherantService;

    @GetMapping
    public String inscriptionForm(Model model) {
        model.addAttribute("inscription", new Inscription());
        model.addAttribute("adherants", adherantService.getAll()); // liste des adhérants
        model.addAttribute("page", "inscription/form");
        return "template";
    }

    @PostMapping
    public String traiterInscription(
            @ModelAttribute Inscription inscription,
            @RequestParam Long adherantId,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Récupérer l'Adherant depuis son ID
        Adherant adherant = adherantService.getById(adherantId);

        if (adherant == null) {
            result.rejectValue("adherant", "error.adherant", "Adhérant invalide.");
            model.addAttribute("adherants", adherantService.getAll());
            model.addAttribute("page", "inscription/form");
            return "template";
        }

        // Associer manuellement
        inscription.setAdherant(adherant);

        // // Sauvegarde finale
        // inscriptionService.save(inscription);
        redirectAttributes.addFlashAttribute("success", "Inscription réussie !");
        return "redirect:/inscriptions";
    }
}
