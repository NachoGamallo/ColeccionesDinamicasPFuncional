package org.example.Colecciones.ExSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsTheory {

    public static void main(String[] args) {

        Set<Character> letras = new HashSet<>();

        letras.add('A');
        letras.add('T');
        letras.add('F');
        letras.add('E');
        letras.add('R');

        System.out.println(letras);

        System.out.println("-------------------");

        Set<Character> letras2 = new LinkedHashSet<>();

        letras2.add('A');
        letras2.add('T');
        letras2.add('F');
        letras2.add('E');
        letras2.add('R');

        System.out.println(letras2);

        System.out.println("-------------------");

        Set<Character> letras3 = new TreeSet<>();

        letras3.add('A');
        letras3.add('T');
        letras3.add('F');
        letras3.add('E');
        letras3.add('R');

        System.out.println(letras3);
    }

}
