package org.example.Colecciones.Comparadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PruebasMaps {

    public static void main(String[] args) {

        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(12324,"Patri");
        mapa.put(58493,"Manuel");
        mapa.put(3452,"Raúl");

        List<Map.Entry<Integer,String>> listaMapa = new ArrayList<>(mapa.entrySet());
        listaMapa.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, String> map2 :listaMapa){

            System.out.println(map2.getKey() + " " + map2.getValue());

        }

    }

}
