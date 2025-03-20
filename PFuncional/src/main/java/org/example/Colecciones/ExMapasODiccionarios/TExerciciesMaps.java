package org.example.Colecciones.ExMapasODiccionarios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TExerciciesMaps {

    static Scanner entry = new Scanner(System.in);
    public static void main(String[] args) {

        //Ex1();
        Ex2();

    }

    public static void Ex1(){

        Map<String, Integer> userChain = new HashMap<>();

        System.out.println("Introduce una frase: ");
        String chain = entry.nextLine();
        String [] userVectorChain = chain.split(" ");

        for (String word : userVectorChain){
            userChain.put(word,userChain.getOrDefault(word,0)+1);
        }

        for (Map.Entry<String,Integer> map : userChain.entrySet()){
            System.out.println(map.getKey() + ": " + map.getValue());
        }
    }

    public static void Ex2(){

        Map < Character , Integer > countLetter = new HashMap<>();
        System.out.println("Ingresa una palabra: ");
        String word = entry.next();

        for (Character letter : word.toCharArray()){
            countLetter.put(letter,countLetter.getOrDefault(letter,0)+1);
        }

        for (Map.Entry<Character,Integer> map : countLetter.entrySet()){
            System.out.println(map.getKey() + ": " + map.getValue());
        }

    }

    public static void Ex4(){



    }

}
