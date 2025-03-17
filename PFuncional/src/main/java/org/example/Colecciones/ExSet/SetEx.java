package org.example.Colecciones.ExSet;

import java.util.*;

public class SetEx {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        //Ex1();
        //Ex3();
        TreeSet <Integer> list1 = new TreeSet<>();
        TreeSet <Integer> list2 = new TreeSet<>();
        list1.add(1);
        list1.add(5);
        list1.add(6);
        list1.add(10);
        list2.add(9);
        list2.add(12);
        list2.add(10);
        System.out.println(Ex4(list1, list2));

    }

    public static void Ex1(){

        Set <String> list = new LinkedHashSet<>();

        System.out.println("Introduce una frase: ");
        String userChain = entry.nextLine();

        String [] userWords = userChain.split(" ");

        Collections.addAll(list, userWords);


        System.out.println(list);

    }

    public static void Ex2(){}

    public static void Ex3(){

        String url;
        int temp = 1;
        Set<String> list = new LinkedHashSet<>();

        do {

            System.out.println("Escribe una URL visitada (o 'salir' para terminar): ");
            url = entry.next();
            if (!url.equalsIgnoreCase("salir")){

                list.add(url);

            }

        }while (!url.equalsIgnoreCase("salir"));

        System.out.println("Historial de navegación:");
        for (String l : list){

            System.out.println(temp++ + ". " + l);

        }
    }

    public static Set<Integer> Ex4(TreeSet <Integer> list1 , TreeSet <Integer> list2 ){

        System.out.println(list1);
        System.out.println(list2);

        Set <Integer> finalList = new TreeSet<>();

        finalList.addAll(list1);
        finalList.addAll(list2);

        while (!list1.isEmpty() || list2.isEmpty()){

            if (!list1.isEmpty()){

                finalList.add(list1.pollFirst());

            }else {

                finalList.add(list2.pollFirst());

            }

        }
        
        return finalList;

    }
}
