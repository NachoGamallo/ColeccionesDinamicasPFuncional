package org.example.Colecciones.ExMapasODiccionarios;

import java.util.HashMap;
import java.util.Map;

public class Pruebas {

    public static void main(String[] args) {

        HashMap<String, Integer> mapaNotas = new HashMap<>();

        mapaNotas.put("Adrian",3);
        mapaNotas.put("Raúl",4);
        mapaNotas.put("Manuel",7);
        mapaNotas.put("Adrian",4);

        System.out.println("Nota Raúl: " + mapaNotas.get("Raúl"));
        System.out.println(mapaNotas.remove("Manuel"));

        System.out.println(mapaNotas.keySet());
        System.out.println(mapaNotas.values());

        if (mapaNotas.containsKey("Adrian")){
            System.out.println("Adrian existe");
        }

        if (mapaNotas.containsValue(10)){
            System.out.println("Alguien tiene un 10");
        }

        for (Map.Entry < String,Integer > notas : mapaNotas.entrySet()){
            System.out.println("Nota de " + notas.getKey() + " es un: " + notas.getValue());
        }
    }
}