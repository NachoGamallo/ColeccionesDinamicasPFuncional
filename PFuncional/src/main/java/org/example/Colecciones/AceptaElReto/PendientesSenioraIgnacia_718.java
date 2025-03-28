package org.example.Colecciones.AceptaElReto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PendientesSenioraIgnacia_718 {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {

        int option = in.nextInt();
        in.nextLine();

        if (option == 0)

            return false;

        else {


            String chain = in.nextLine();
            String [] userChain = chain.split(" ");
            Set <Integer> nums = new HashSet<>();
            int repeated = 0;

            for (String pos : userChain){

                int posReal = Integer.parseInt(pos);

                if (!nums.add(posReal)){

                    nums.remove(posReal);
                    repeated++;

                }
            }

            System.out.println(repeated);

            return true;
        }
    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        while (casoDePrueba()) {}
    }
}
