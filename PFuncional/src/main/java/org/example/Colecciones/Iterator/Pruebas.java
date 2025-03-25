package org.example.Colecciones.Iterator;

import java.util.*;

public class Pruebas {
    public static void main(String[] args) {

        LinkedList < Integer > numeros = new LinkedList<>(Arrays.asList(10,23,45,1,3,5));

        Iterator < Integer > it = numeros.iterator();

        while (it.hasNext()){
            Integer num = it.next();
            System.out.println(num);

            if (num == 23){
                it.remove();
            }
        }

        ArrayList < Casino > listaCasino = new ArrayList<>();
        listaCasino.add(new Casino("poker",500));
        listaCasino.add(new Casino("ruleta",25));
        listaCasino.add(new Casino("blackJack",50));
        Iterator < Casino > casinoIterator = listaCasino.iterator();

        while (casinoIterator.hasNext()){

            Casino casino = casinoIterator.next();
            System.out.println(casino);
            if (casino.getApuestaMinima() < 30){

                casinoIterator.remove();

            }

        }

        System.out.println(casinoIterator);

        HashMap <String,String> diccionario = new HashMap<>();



    }
}
