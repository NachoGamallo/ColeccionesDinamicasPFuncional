package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();
        pila.push(5);
        pila.push(10);
        pila.push(2);
        pila.push(7);
        pila.push(22);
        pila.push(34);

        System.out.println(pila.peek());

        for (Integer num : pila){
            System.out.println(num);
        }

        pila.pop();
        System.out.println(pila.peek());

        while (!pila.isEmpty()){
            pila.pop();
        }
    }
}