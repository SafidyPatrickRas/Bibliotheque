package com.bibliotheque.Bibliotheque.controller;

import com.bibliotheque.Bibliotheque.service.InscriptionService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;

    // public String inscriptionForm(Model model) {
    //     model.addAttribute("inscription", new Inscription());
    //     model.addAttribute("page", "inscription/form");
    //     return "template";
    // }
}
