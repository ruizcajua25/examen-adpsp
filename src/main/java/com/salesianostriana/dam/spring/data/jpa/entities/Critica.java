package com.salesianostriana.dam.spring.data.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Critica {
    private Long id;
    private String autor;
    private String texto;
    private float puntuacion;

    @ManyToOne
    Pelicula pelicula;
}
