package org.example.Colecciones.ExMapasODiccionarios.T3ExMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExProgramame_152 {

    static Scanner entry = new Scanner(System.in);

    public static boolean casoDePrueba() {

        int num = entry.nextInt();
        entry.nextLine();

        if (num == 0){

            return false;

        }else {

            String numbers = entry.nextLine();
            String [] chain = numbers.split(" ");
            Integer bigger = 0;
            String bigger_num = "";

            Map<String, Integer> mapNums = new HashMap<>();
            for (String nums : chain){

                if (mapNums.containsKey(nums)){
                    mapNums.put(nums,mapNums.get(nums)+1);
                }else {
                    mapNums.put(nums,1);
                }

                if (mapNums.get(nums) > bigger){
                    bigger_num = nums;
                    bigger = mapNums.get(nums);
                }

            }

            System.out.println(bigger_num);
            return true;

        }

    }

    public static void main(String[] args) {
        while (casoDePrueba()) {}
   } // mai
}
