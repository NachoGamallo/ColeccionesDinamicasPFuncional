package org.example.Colecciones.ExMapasODiccionarios.T3ExMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TemperatureRegister {

    private HashMap<String, Integer> temperature;
    static Scanner entry = new Scanner(System.in);

        public TemperatureRegister(){
            temperature = new HashMap<>();
        }

        public void insertTemperature(String city , Integer temperatures){

            temperature.put(city,temperatures);

        }

        public void updateTemperature(String city){
            System.out.println("Introduce la temperatura para " + city + ":");

            temperature.put(city,entry.nextInt());
        }

        public void getTemperature(){
            System.out.println("Que ciudad quieres consultar? :");
            String city = entry.next();

            if (temperature.containsKey(city)){
                System.out.println("La ciudad " + city + " tiene una temperatura de " + temperature.get(city));
            }else {
                System.out.println("La ciudad " + city + " no esta registrada.");
            }
        }

        public void getAllTemperatures(){

            for (Map.Entry <String,Integer> temp : temperature.entrySet()){
                System.out.println(temp.getKey() + ": " + temp.getValue() + "º");
            }

        }

}
