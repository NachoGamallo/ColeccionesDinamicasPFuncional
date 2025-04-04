package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

@Getter
@ToString
@Setter
public class Order {

    final int DEFAULT_VALUE = 0;
    HashMap < Product , Integer > productsList;
    double totalAmount;

    public Order(){
        this.productsList = new LinkedHashMap<>();
        this.totalAmount = DEFAULT_VALUE;
    }


    private double applyPromo3x2(){

        double totalToDiscount = 0;
        for (Map.Entry<Product,Integer> line : productsList.entrySet()){
            if (line.getValue() >= 3){
                int temp = line.getValue() / 3;
                totalToDiscount += (float) line.getKey().getPrice() * temp;

            }
        }
        return totalToDiscount;
    }

    private double applyPromo10(){

        return totalAmount * 0.10;

    }

    public void checkClientPromo(Client client){

        if (client.getPromo()){

            double discount10 = applyPromo10();
            double discount3x2 = applyPromo3x2();

            this.totalAmount -= (discount10 + discount3x2);
            client.setPromo(false);

            System.out.println("PROMO 3x2 Y 10% APLICADAS.");

        }else {

            System.out.println("YA HAS APLICADO TUS PROMOS.");
        }

    }

    public void addProduct(Product product, Integer num){
        this.productsList.put( product , this.productsList.getOrDefault(product,0) + num);
    }

    public void getProducts(){

        for (Map.Entry<Product, Integer> line : productsList.entrySet()){

            System.out.println(line.getValue() + " " + line.getKey() + " " + line.getKey().getPrice());

        }

    }

    public void getSortedProducts(){

        List<Map.Entry<Product,Integer>> sortedList = new ArrayList<>(productsList.entrySet());
        sortedList.sort((value1 , value2) -> value2.getValue().compareTo(value1.getValue()));//Ordenamos esta copia del map,
        // comparando los valores Integer del Map.

        System.out.println("RESUMEN DE TU CARRITO DE LA COMPRA:");
        System.out.println("Productos ordenados por Numero de unidades.");
        for (Map.Entry<Product , Integer> line : sortedList){

            System.out.println(line.getValue() + " " + line.getKey() + " " + line.getKey().getPrice());

        }

        System.out.println("IMPORTE TOTAL: " + String.format("%.2f", this.getTotalAmount()));
    }
}
