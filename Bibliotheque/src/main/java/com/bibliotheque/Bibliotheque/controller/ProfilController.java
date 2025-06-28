package com.bibliotheque.Bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bibliotheque.Bibliotheque.model.Profil;
import com.bibliotheque.Bibliotheque.service.ProfilService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/profils")
public class ProfilController {
    
    @Autowired
    private ProfilService profilService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("profils", profilService.getAll());
        model.addAttribute("page", "profil/list");
        return "template";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("profil", new Profil());
        model.addAttribute("page", "profil/form");
        return "template";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Profil profil, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "profil/form");
            return "template";
        }

        profilService.save(profil);
        return "redirect:/profils";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Profil profil = profilService.getById(id);
        if (profil == null) return "redirect:/profils";
        model.addAttribute("profil", profil);
        model.addAttribute("page", "profil/form");
        return "template";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        profilService.delete(id);
        return "redirect:/profils";
    }
}
