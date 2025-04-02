package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

@Getter
@ToString
public class Client {

    final String FALSE_ADDRESS = "CALLE FALSA, 123";
    private String user;
    private String password;
    private Order order;
    private boolean promo;
    private String address;
    static Scanner entry = new Scanner(System.in);

    public Client(String user, String password, Order order, boolean promo){

        this.user = user;
        this.password = password;
        this.order = order;
        this.promo = promo;
        this.address = FALSE_ADDRESS;

    }

    public Client(String user, String password, Order order, boolean promo, String address){

        this.user = user;
        this.password = password;
        this.order = order;
        this.promo = promo;
        this.address = address;

    }



    public void createOrder(){

        this.order = new Order();

    }

    public boolean insertProduct(String userProduct){

        System.out.println("====================================");

        for (Product p : Product.values()){
            if (userProduct.equalsIgnoreCase(p.toString())){
                this.order.addProduct(p,1);

                System.out.println(order.productsList.toString());
                System.out.println("Has añadido " + p + " con un precio de " + p.getPrice() + " €. Importe total del carrito: "
                        + orderAmount() + "€. Quieres añadir mas productos a tu carrito de la compra? [S/N]");
                return optionOrder(entry.next());
            }
        }

        System.out.println("El producto no existe! Elige otro.");
        return false;
    }

    private boolean optionOrder(String option){
        switch (option){
            case "S":
                return false;

            case "N":
                return true;

            default:
                System.out.println("Opcion no valida, introduce una opcion correcta [S/N]");
                optionOrder(entry.next());
        }
        return false;
    }

    public double orderAmount(){//Bucle en una sola linea, sin necesidad de for usamos stream para recorrer el Map, convertimos
        //la key (Producto y obtenemos el precio de este) * value (Integer , num de productos) y hacemos la suma de todas las lineas
        // de nuestra order.
        return this.order.productsList.entrySet().stream()
                .mapToDouble(line -> (line.getKey().getPrice()*line.getValue())).sum();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(user, client.user) && Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

}
