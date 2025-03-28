package org.example.Colecciones.inmutabilidad;

import java.util.List;

public class Prueba {

    public static void main(String[] args) {

        juego pokemon = new juego("pokemon plata",100);
        List<String> listaPokemons = pokemon.getChampList();
        listaPokemons.add("Pikachu");
        pokemon.getChampList().add("Squirtle");
        pokemon.getChampList().add("Charmander");

        System.out.println(pokemon.getChampList());
    }

}
