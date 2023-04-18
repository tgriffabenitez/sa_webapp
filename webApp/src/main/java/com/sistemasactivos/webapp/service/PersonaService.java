package com.sistemasactivos.webapp.service;

import com.sistemasactivos.webapp.model.Persona;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PersonaService {

    public Flux<Persona> findAll() {
        return WebClient.create("http://localhost:8082")
                .get()
                .uri("/personas")
                .retrieve()
                .bodyToFlux(Persona.class);
    }
}
