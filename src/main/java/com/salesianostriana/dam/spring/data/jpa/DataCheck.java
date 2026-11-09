package com.salesianostriana.dam.spring.data.jpa;

import com.salesianostriana.dam.spring.data.jpa.entities.Pelicula;
import com.salesianostriana.dam.spring.data.jpa.repositories.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataCheck {
    @Autowired
    PeliculaRepository peliculaRepository;
    @PostConstruct
    @DependsOn("dataSeed")
    public void comprobarDatos() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        peliculas.stream().forEach(pelicula -> System.out.println(pelicula.getTitulo()));

        Optional<Pelicula> pelicula = peliculaRepository.findById(1L);

        if(pelicula.isPresent()) {
            System.out.println(pelicula.get());
        }
    }
}
