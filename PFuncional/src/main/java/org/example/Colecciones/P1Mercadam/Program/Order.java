package org.example.Colecciones.P1Mercadam.Program;

import java.util.HashMap;

public class Order {

    final int DEFAULT_VALUE = 0;
    HashMap < Product , Integer > productsList;
    double totalAmount;

    public Order(){
        this.productsList = new HashMap<>();
        this.totalAmount = DEFAULT_VALUE;
    }

    public void applyPromo3x2(){}

    public void applyPromo10(){}

}
