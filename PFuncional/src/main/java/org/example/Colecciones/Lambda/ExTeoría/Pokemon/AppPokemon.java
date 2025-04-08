package org.example.Colecciones.Lambda.ExTeoría.Pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppPokemon {
    public static void main(String[] args) {

        Pokedex pokedex = new Pokedex("Squirtle",5);
        Pokedex pokedex1 = new Pokedex("Charmander",2);

        Pokemon magikarp = new Pokemon() {
            @Override
            public void atacar(int lvl , Pokedex poke) {
                System.out.println("SALPICADURA de nivel " + lvl + " ataca a " + poke.getPokemon());
            }
        };

        magikarp.atacar(15,pokedex);

        Pokemon pikachu = (int lvl , Pokedex poke) -> {
            System.out.println("IMPACTRUENO de nivel " + lvl + " ataca a " + poke.getPokemon());
            System.out.println("Pica Pica");
        };

        pikachu.atacar(12,pokedex1);

        List<Pokedex> listaPokes = new ArrayList<>();
        listaPokes.add(pokedex1);
        listaPokes.add(pokedex);
        listaPokes.add(new Pokedex("Bulbasur",15));

        listaPokes.sort((x,y) -> x);


    }
}
