package com.salesianostriana.dam.spring.data.jpa.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    private Long id;
    private String titulo;
    private LocalDate anioEstrino;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    @Builder.Default
    Set<Critica> criticas = new HashSet<Critica>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    Set<Genero> generos;

    public void addCritica (Critica critica) {
        criticas.add(critica);
        critica.setPelicula(this);
    }

    public void removeCritica(Critica critica) {
        criticas.add(critica);
        critica.setPelicula(null);
    }
}
