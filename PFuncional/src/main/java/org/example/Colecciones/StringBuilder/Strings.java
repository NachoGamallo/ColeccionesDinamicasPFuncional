package org.example.Colecciones.StringBuilder;

public class Strings {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hola");
        sb.append("que tal");
        sb.insert(5,"soy Nacho");
        sb.replace(5,8,"Somos");
        sb.delete(0,5);
    }

}
