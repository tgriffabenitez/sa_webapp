package com.sistemasactivos.webapp.controller;

import com.sistemasactivos.webapp.model.Categoria;
import com.sistemasactivos.webapp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String obtenerCategorias(Model modelo) {
        Flux<Categoria> categorias = categoriaService.findAll();
        modelo.addAttribute("categoria", categorias.collectList().block());
        return "Categoria";
    }

    @GetMapping("/categoria/{id}")
    public String obtenerCategoria(Model modelo, @PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id).block();
        modelo.addAttribute("categoria", categoria);
        return "Categoria";
    }
}
