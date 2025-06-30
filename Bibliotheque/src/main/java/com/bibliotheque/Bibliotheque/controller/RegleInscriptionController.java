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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bibliotheque.Bibliotheque.model.RegleInscription;
import com.bibliotheque.Bibliotheque.service.ProfilService;
import com.bibliotheque.Bibliotheque.service.RegleInscriptionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/regles_inscription")
public class RegleInscriptionController {

    @Autowired
    private RegleInscriptionService regleInscriptionService;

    @Autowired
    private ProfilService profilService; 
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("reglesInscription", regleInscriptionService.getAll());
        model.addAttribute("page", "regle_inscription/list");
        return "template";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("regleInscription", new RegleInscription());
        model.addAttribute("profils" , profilService.getAll());
        model.addAttribute("page", "regle_inscription/form");
        return "template";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute RegleInscription regleInscription, BindingResult result, Model model , RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("page", "regle_inscription/form");
            model.addAttribute("profils" , profilService.getAll());
            return "template";
        }
        if(regleInscription.getId()!=null){
            try {
                regleInscriptionService.update(regleInscription);
                redirectAttributes.addFlashAttribute("success", "Mis a jour reussi!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            }
            
        }else{
            try {
                regleInscriptionService.save(regleInscription);
                redirectAttributes.addFlashAttribute("success", "Règle ajoutée avec succès !");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            }
        }
        
        
        return "redirect:/regles_inscription";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        RegleInscription regleInscription = regleInscriptionService.getById(id);
        if (regleInscription == null) return "redirect:/regle_inscription";
        model.addAttribute("regleInscription", regleInscription);
        model.addAttribute("profils" , profilService.getAll());
        model.addAttribute("page", "regle_inscription/form");
        return "template";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id , RedirectAttributes redirectAttributes) {
        try {
            redirectAttributes.addFlashAttribute("success", "Règle supprimer avec succès !");
            regleInscriptionService.delete(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
        }
        
        return "redirect:/regles_inscription";
    }
}
