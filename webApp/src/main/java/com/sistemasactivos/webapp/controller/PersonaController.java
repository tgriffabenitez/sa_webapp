package com.sistemasactivos.webapp.controller;

import com.sistemasactivos.webapp.model.Persona;
import com.sistemasactivos.webapp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;


@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public String obtenerPersonas(Model modelo) {
        Flux<Persona> personas = personaService.findAll();
        modelo.addAttribute("persona", personas.collectList().block());
        return "Persona";
    }

    @GetMapping("/persona/{id}")
    public String obtenerPersona(Model modelo, @PathVariable Long id) {
        Persona persona = personaService.findById(id).block();
        modelo.addAttribute("persona", persona);
        return "Persona";
    }
}
