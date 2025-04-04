package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

/**
 * Este es el objeto donde almacenamos toda la informacion de las Ordenes de los clientes, este depende de Cliente para existir.
 * Tiene la información de todos los productos introducidos por el usuario al que esta vinculado.
 * @author Nacho Gamallo estudiante 1DAM en IES MUTXAMEL.
 * @version 1.0
 */
@Getter
@ToString
@Setter
public class Order {

    final int DEFAULT_VALUE = 0;
    HashMap < Product , Integer > productsList;
    double totalAmount;

    /**
     * Creamos un Map vacío , definido como LinkedHashMap para que se introduzcan los datos en orden de entrada.
     * Y definimos el total a 0 por defecto.
     */
    public Order(){
        this.productsList = new LinkedHashMap<>();
        this.totalAmount = DEFAULT_VALUE;
    }


    /**
     * Con esta función vamos vamos a recorrer el Map y comprobar los productos que esten más de 3 veces ,
     * para aplicar una oferta de 3x2 (reducimos el precio de 1)
     * @return Nos devuelve el total a descontar de totalAmount.
     */
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

    /**
     * Promoción de 10% menos de precio.
     * @return Devolvemos el 10% de el total de la Order.
     */
    private double applyPromo10(){

        return totalAmount * 0.10;

    }

    /**
     * Con esta función lo que vamos a hacer es verificar si el cliente tiene la promo a true, si la tiene vamos a aplicar los descuentos
     * sino , tendremos que decirle que ya ha aplicado sus promociones.
     * Restaremos al total de la Order lo que nos devuelvan los descuentos (si es true que tiene promo).
     * @see #applyPromo3x2() sacamos el total de la promo3x2 a descontar
     * @see #applyPromo10() sacamos el total de la promo10% a descontar
     * @see Client#setPromo(boolean) Una vez aplicado el descuento , pondremos false a promo del cliente. Porque ya la hemos aplicado.
     * @param client Cliente el cual se vera afectado.
     */
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

    /**
     * Con este método vamos a imprimir todos los productos de la lista con un formáto concreto.
     * Numero de productos + Producto + precio.
     */
    public void getProducts(){

        for (Map.Entry<Product, Integer> line : productsList.entrySet()){

            System.out.println(line.getValue() + " " + line.getKey() + " " + line.getKey().getPrice());

        }

    }

    /**
     * En esté método haremos lo mismo que getProducts,
     * pero ahora vamos a hacer una copía del Map, en un List para ordenarlo por número de Productos de mayor a menor.
     * Hemos usado la función sort, para comparar los valores de el Map y así poder ordenar.
     * Una vez ordenado imprimimos la sorted list (List con valores del Map).
     */
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
