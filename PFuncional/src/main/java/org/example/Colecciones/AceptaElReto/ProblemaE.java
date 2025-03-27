package org.example.Colecciones.AceptaElReto;

import java.util.Scanner;

public class ProblemaE {

    static Scanner in;

    public static void casoDePrueba() {

        String code = in.nextLine();
        String[] nums = code.split(" ");

        boolean esPrimo = false;
        int sum = 0;
        boolean noOrder = true;
        boolean temp = false;

        for ( int i = 1 ; i <= nums.length-1 ; i++ ){

            sum += Integer.parseInt(nums[i]);

            if (!esPrimo){

                for (int x = 2; x < Integer.parseInt(nums[i]) ; x++ ){

                    if (Integer.parseInt( nums[i]) % x == 0){

                        temp = false;
                        break;

                    }else {

                        temp = true;

                    }

                }

            }

            if (temp || Integer.parseInt(nums[i]) == 1 || Integer.parseInt(nums[i]) == 2 ){

                esPrimo = true;

            }

            if (Integer.parseInt(nums[i]) < nums.length-1 && Integer.parseInt(nums[i]) > Integer.parseInt(nums[i+1])){
                noOrder = false;
            }

            if (!noOrder){
                break;
            }

        }

        if (!noOrder || sum > 100 || !esPrimo){

            System.out.println("INVALIDO");

        }else {

            System.out.println("VALIDO");

        }

    }

    public static void main(String[] args) {

        in = new Scanner(System.in);

        int numCasos = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }

}
