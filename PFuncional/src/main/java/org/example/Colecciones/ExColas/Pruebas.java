package org.example.Colecciones.ExColas;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Pruebas {

    public static void main(String[] args) {

        Queue<Integer> cola = new ArrayBlockingQueue<>(2);
        cola.add(3);
        cola.add(1);

        Queue<Integer> cola2 = new LinkedList<>();

        cola.offer(23);
        cola.offer(35);
        cola.offer(11);

        System.out.println(cola2.poll());

        Deque<Integer> cola_doble = new LinkedList<>();

        cola_doble.offer(3);
        cola_doble.offerFirst(6);
        cola_doble.offerLast(10);
        cola_doble.pollFirst();
        cola_doble.pollLast();
    }

}
