package org.example.Colecciones.Lambda.ExTeoría;

public class EjerciciosT1 {
    public static void main(String[] args) {

        Ex1T ex1T = (num) -> {
            System.out.println("Comparando para " + num);
            return num >= 10;
        };

        System.out.println(ex1T.TEx1(10));
        System.out.println(ex1T.TEx1(12));
        System.out.println(ex1T.TEx1(3));

    }
}
