package org.example.Colecciones.StringBuilder;

import java.util.Random;

public class Bus {

    public static final int TAM = 97;
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        int mutxa = 0;
        int sanvi = 0;

        System.out.println("\n<<<<<<<<<< Carrera de Autobuses >>>>>>>>>>");
        Thread.sleep(3000);

        while (mutxa < TAM && sanvi < TAM) {

            mutxa += random.nextInt(2);
            sanvi += random.nextInt(2);

            limpiarPantalla();

            if (mutxa < TAM && sanvi < TAM) {
                System.out.println(dibujarCarrera(mutxa,sanvi));
                Thread.sleep(70);
            }

        }

        if (mutxa == TAM && sanvi == TAM){

            System.out.println("\033[32m"+ "HA HABIDO UN EMPAATEE!!" + "\033[0m");

        } else if (mutxa == TAM){
            System.out.println("\033[32m"+ "EL AUTOBUSITO DE MUTXAMEL HA GANADO LA CARRERA!!" + "\033[0m");
        }else {
            System.out.println("\033[32m"+ "EL AUTOBUSITO DE SAN VICENTE HA GANADO LA CARRERA!!" + "\033[0m");
        }

    }

    public static String dibujarCarrera(int n1 , int n2) {

        StringBuilder sb = new StringBuilder();

        sb.append("-".repeat(117)).append("\n");
        sb.append(" ".repeat(n1)).append("_______________  ").append(" ".repeat(100 - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|__|__|__|__|__|___ ").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|   IES MUTXAMEL  |)").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|~~~@~~~~~~~~~@~~~|)").append(" ".repeat(TAM - n1)).append("|\n");

        sb.append(" ".repeat(n2)).append("_______________  ").append(" ".repeat(100 - n2)).append("|\n");
        sb.append(" ".repeat(n2)).append("|__|__|__|__|__|___ ").append(" ".repeat(TAM - n2)).append("|\n");
        sb.append(" ".repeat(n2)).append("| IES SAN VICENTE |)").append(" ".repeat(TAM - n2)).append("|\n");
        sb.append(" ".repeat(n2)).append("|~~~@~~~~~~~~~@~~~|)").append(" ".repeat(TAM - n2)).append("|\n");

        sb.append("_".repeat(117));

        return sb.toString();
    }

    public static void limpiarPantalla() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}

