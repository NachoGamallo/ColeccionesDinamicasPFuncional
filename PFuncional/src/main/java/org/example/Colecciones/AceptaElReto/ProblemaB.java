package org.example.Colecciones.AceptaElReto;

import java.util.ListIterator;

public class ProblemaB {

    static java.util.Scanner in;

    public static void casoDePrueba() {

        boolean status = true;


        String word = in.next();
        if (word.length() < 12 || word.length() > 30){
            status = false;
        }


        byte min = 0;
        byte max = 0;
        byte num = 0;
        byte symbol = 0;

        for (Character character : word.toCharArray()){


        }

        if (status){
            System.out.println("OK");
        }else {
            System.out.println("ERROR");
        }

    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }

}
