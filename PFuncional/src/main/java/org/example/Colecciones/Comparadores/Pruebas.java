package org.example.Colecciones.Comparadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pruebas {
    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Jose","Ampeter","ManuelV","Josebas","Mariaun"));
        Collections.sort(nombres);

        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Sudadera",6));
        listaProductos.add(new Producto("Pan",1));
        listaProductos.add(new Producto("Arroz",4));
        listaProductos.add(new Producto("Arroz",6));

        Collections.sort(listaProductos,new CompareWithPrice());
        System.out.println(listaProductos);

    }
}
