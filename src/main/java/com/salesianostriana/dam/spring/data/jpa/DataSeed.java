package com.salesianostriana.dam.spring.data.jpa;

import com.salesianostriana.dam.spring.data.jpa.entities.Critica;
import com.salesianostriana.dam.spring.data.jpa.entities.Genero;
import com.salesianostriana.dam.spring.data.jpa.entities.Pelicula;
import com.salesianostriana.dam.spring.data.jpa.repositories.CriticaRepository;
import com.salesianostriana.dam.spring.data.jpa.repositories.GeneroRepository;
import com.salesianostriana.dam.spring.data.jpa.repositories.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataSeed {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private CriticaRepository criticaRepository;

    @PostConstruct
    public void cargarDatos() {

        Genero genero1 = generoRepository.save(
                new Genero(
                    6L,
                    "miedo"
                )
        );

        Genero genero2 = generoRepository.save(
                new Genero(
                    7L,
                    "acción"
                )
        );

       Pelicula pelicula1 =  peliculaRepository.save(
            new Pelicula(
                1L,
                "titulo1",
                LocalDate.now(),
                new HashSet<Critica>(),
                new HashSet<Genero>()
            )
        );

        Pelicula pelicula2 = peliculaRepository.save(
                new Pelicula(
                    2L,
                    "titulo2",
                    LocalDate.now(),
                    new HashSet<Critica>(),
                    new HashSet<Genero>()
                )
        );

        criticaRepository.save(
                new Critica(
                       3L,
                       "juan",
                       "lolkfjalkjflaj",
                       3.4f,
                        pelicula1
                )
        );

        criticaRepository.save(
                new Critica(
                        4L,
                        "manuelk",
                        "fdsafdsafjksadlkfas",
                        8.2f,
                        pelicula1
                )
        );

        criticaRepository.save(
                new Critica(
                        5L,
                        "juan",
                        "lolkfjalkjflaj",
                        5.4f,
                        pelicula2
                )
        );

        pelicula1.getGeneros().add(genero1);
        peliculaRepository.save(
        pelicula1
                );
        pelicula2.getGeneros().add(genero1);
        peliculaRepository.save(
        pelicula2
                );

    }
}
