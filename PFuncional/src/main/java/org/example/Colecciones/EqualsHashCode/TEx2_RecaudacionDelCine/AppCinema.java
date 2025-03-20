package org.example.Colecciones.EqualsHashCode.TEx2_RecaudacionDelCine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AppCinema {

    static Random random = new Random();
    static Queue<Person> listPersons = new LinkedList<>();

    public static void main(String[] args) {

        int totalPersons;
        totalPersons = random.nextInt(251);
        generateTail(totalPersons);

    }

    public static void generateTail(int total){

        for (int i = 0 ; i <= total ; i++ ){

            int age = random.nextInt(97)+3;
            listPersons.add(new Person(age));

        }

        System.out.println("Hay " + total + " personas a la cola, " + listPersons);
        System.out.println("La recaudacion ha sido de " + totalAmount() + "€");

    }

    public static double moneyPerAge(int age){

        if (age > 3 && age < 10){

            return 1;

        } else if (age > 11 && age < 17) {

            return 2.5;

        }else {

            return 3.5;

        }
    }

    public static double totalAmount(){
        double totalAmount = 0;
        while (!listPersons.isEmpty()){

            totalAmount += moneyPerAge(listPersons.poll().getAge());

        }
        return totalAmount;
    }
}
