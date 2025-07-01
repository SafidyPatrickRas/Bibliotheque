package com.bibliotheque.Bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bibliotheque.Bibliotheque.service.InscriptionService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;
}
