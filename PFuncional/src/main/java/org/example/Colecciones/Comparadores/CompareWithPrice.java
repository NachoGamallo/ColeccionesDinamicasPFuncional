package org.example.Colecciones.Comparadores;

import java.util.Comparator;

public class CompareWithPrice implements Comparator<Producto> {


    @Override
    public int compare(Producto product1, Producto product2) {

        int comparePrice = product1.getPrice().compareTo(product2.getPrice());

        if (comparePrice != 0){

            return comparePrice;

        }

        return product1.getName().compareTo(product2.getName());
    }
}
