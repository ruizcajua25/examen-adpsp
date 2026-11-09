package com.salesianostriana.dam.spring.data.jpa.repositories;

import com.salesianostriana.dam.spring.data.jpa.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
