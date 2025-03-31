package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Client {

    final String FALSE_ADDRESS = "CALLE FALSA, 123";
    private String user;
    private String password;
    private Order order;
    private boolean promo;
    private String address;

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



    public void createOrder(){}

    public void insertProduct(){}

    public void orderAmount(){}



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
