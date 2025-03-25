package org.example.Colecciones.Iterator;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MaquinaMaria {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Escribe un texto...");
        String userChain = entry.nextLine();

        LinkedList < Character > text = new LinkedList<>();

        ListIterator< Character > it = text.listIterator();

        for (char c : userChain.toCharArray()){

            switch (c){

                case '<':

                    if (it.hasPrevious()){
                        it.previous();
                    }

                    break;

                case '>':

                    if (it.hasNext()){
                        it.next();
                    }

                    break;

                case '#':

                    if (it.hasPrevious()){
                        it.previous();
                        it.remove();

                    }

                    break;

                default:

                    it.add(c);

                    break;

            }
        }
        for (char c : text){
            System.out.print(c);
        }
    }
}
