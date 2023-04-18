package com.sistemasactivos.webapp.service;

import com.sistemasactivos.webapp.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaService {

    @Autowired
    @Qualifier("webClientPersona")
    private WebClient webClientPersona;


    public Flux<Persona> findAll() {
        return webClientPersona.get()
                .uri("/personas")
                .retrieve()
                .bodyToFlux(Persona.class);
    }

    public Mono<Persona> findById(Long id) {
        return webClientPersona.get()
                .uri("/persona/" + id)
                .retrieve()
                .bodyToMono(Persona.class);
    }

}
