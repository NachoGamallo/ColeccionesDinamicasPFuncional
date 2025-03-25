package org.example.Colecciones.AceptaElReto;

import java.util.LinkedList;
import java.util.ListIterator;

public class TecladoEstropeado_144 {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {

            String chain = in.nextLine();

            LinkedList < Character > text = new LinkedList<>();
            ListIterator < Character > it = text.listIterator();

            for (char c : chain.toCharArray()){

                switch (c){
                    case '-':
                        while (it.hasPrevious()){it.previous();}
                        break;
                    case '+':
                        while (it.hasNext()){it.next();}
                        break;
                    case '*':
                        if (it.hasNext()){it.next();}
                        break;
                    case '3':
                        if (it.hasNext()){
                            it.next();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(c);
                        break;
                }
            }

            StringBuilder line = new StringBuilder();
            for (char c : text){
                line.append(c);
            }
            System.out.println(line);
            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {}
    }
}
