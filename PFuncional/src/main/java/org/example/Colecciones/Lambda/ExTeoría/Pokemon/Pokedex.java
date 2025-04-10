package org.example.Colecciones.Lambda.ExTeoría.Pokemon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pokedex {
    private String pokemon;
    private Integer entrenadores;

    public Pokedex(String pokemon, Integer entrenadores){

        this.entrenadores = entrenadores;
        this.pokemon = pokemon;

    }
}
