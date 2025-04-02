package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;
import lombok.ToString;
import java.util.HashMap;

@Getter
@ToString
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

    public void addProduct(Product product, Integer num){
        this.productsList.put( product , this.productsList.getOrDefault(product,0) + num);
    }
}
