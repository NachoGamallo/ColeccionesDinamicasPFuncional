
package org.example.Colecciones.ExPilas;

import java.util.Scanner;
import java.util.Stack;

public class TeoriaEx {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        //Ex1();
        //Ex2();
        Ex3();
    }

    public static void Ex1 (){

        Stack<String> pila = new Stack<>();
        pila.push("H");
        pila.push("O");
        pila.push("L");
        pila.push("A");
        pila.push("!");
        if (pila.isEmpty()){
            System.out.println("Esta vacía.");
        }else {
            System.out.println("No esta vacía.");
        }
        System.out.println(pila.size());
        System.out.println(pila.peek());
        System.out.println(pila.pop());
    }

    public static void Ex2(){

        int num = 3;
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i  < num ; i++){
            System.out.println("Introduce el número " + (i+1) + " :");
            pila.push(entry.nextInt());
        }

        System.out.println("-------------");

        while (!pila.isEmpty()){
            System.out.println(pila.pop());
        }

    }

    public static void Ex3(){

        System.out.println("Introduce la operación:");

        if (esBalanceado(entry.next())){

            System.out.println("Formato correcto.");

        }else {

            System.out.println("Formato incorrecto.");

        }
    
    }

    public static boolean esBalanceado(String chain){

        Stack<String> pila = new Stack<>();
        String[] chainValue = chain.split("");

        for ( int i = 0 ; i<chain.length() ; i++ ){

            if (chainValue[i].equals("(") || chainValue[i].equals(")") && !pila.contains("(")){

                pila.push(chainValue[i]);

            } else if (chainValue[i].equals(")") && pila.contains("(")) {
                pila.pop();
            }

        }

        return pila.isEmpty();

    }
}
