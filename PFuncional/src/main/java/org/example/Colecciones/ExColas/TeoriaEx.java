package org.example.Colecciones.ExColas;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TeoriaEx {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        Ex1();
        Ex2();
        Ex3();
        Ex4();
        Ex5();

    }

    public static void Ex1(){

        Queue<Character> cola = new LinkedList<>();
        cola.offer('H');
        cola.offer('O');
        cola.offer('L');
        cola.offer('A');
        cola.offer('!');

        if (cola.isEmpty()){
            System.out.println("vacía");
        }else {
            System.out.println("No esta vacía");
        }

        System.out.println(cola.size());

        System.out.println(cola.peek());

        System.out.println(cola.poll());

    }

    public static void Ex2(){

        Queue <String> print = new LinkedList<>();
        print.offer("Imprimir documento 1");
        print.offer("Imprimir documento 2");
        print.offer("Imprimir documento 3");
        print.offer("Imprimir documento 4");
        print.offer("Imprimir documento 5");

        while (!print.isEmpty()){

            System.out.println(print);
            print.poll();

        }
    }

    public static void Ex3(){

        Queue<String> spotify = new LinkedList<>();
        spotify.offer("El pete de wanda - Bananero");
        spotify.offer("Acomodate en mi cama - AntoneloBBY");
        spotify.offer("Duro 2 horas - Faraon Love Shaidy");
        spotify.offer("DArkSIDE - Bring me the Horizon");

        while (!spotify.isEmpty()){

            System.out.println(spotify);
            System.out.println("Reproduciondo: " + spotify.poll());

        }

        System.out.println("La playlist ha terminado.");

    }

    public static void Ex4(){

        System.out.println("--- LISTA DE LA COMPRA ---");
        System.out.println("1. Añadir producto al final");
        System.out.println("2. Eliminar primer producto");
        System.out.println("3. Eliminar producto por nombre");
        System.out.println("4. Ver primer producto");
        System.out.println("5. Buscar producto");
        System.out.println("6. Mostrar lista actual");
        System.out.println("X. Salir");
    }

    public static void Ex5(){

        Deque<Character> cola = new LinkedList<>();
        System.out.println("Introduce palabra:");
        String word = entry.next();

        for (int i = 0 ; i < word.length() ; i++ ){
            cola.offer(word.charAt(i));
        }

        System.out.println(isPalindromo(cola) ? "Es Palindroma" : "No es Palindroma");
    }

    public static boolean isPalindromo(Deque < Character > list){

        if (list.peekFirst() == list.peekLast()){

            list.pollFirst();
            list.pollLast();

            if(list.size() > 1){
                isPalindromo(list);
            }

        }else {
            return false;
        }

        return true;
    }

}
