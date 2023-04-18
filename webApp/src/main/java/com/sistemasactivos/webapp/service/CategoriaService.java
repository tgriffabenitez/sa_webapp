package com.sistemasactivos.webapp.service;

import com.sistemasactivos.webapp.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoriaService {

    @Autowired
    @Qualifier("webClientBff")
    private WebClient webClientCategoria;

    public Flux<Categoria> findAll() {
        return webClientCategoria.get()
                .uri("/categorias")
                .retrieve()
                .bodyToFlux(Categoria.class);
    }

    public Mono<Categoria> findById(Long id) {
        return webClientCategoria.get()
                .uri("/categoria/" + id)
                .retrieve()
                .bodyToMono(Categoria.class);
    }

}
