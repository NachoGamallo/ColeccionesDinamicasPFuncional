package org.example.Colecciones.Comparadores;

import java.util.Objects;

public class Producto implements Comparable<Producto>{

    private String name;
    private Integer price;

    public Producto(String name, int price){

        this.name = name;
        this.price = price;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return price == producto.price && Objects.equals(name, producto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Producto product) {
        int comparatorName = name.compareTo(product.name);

        if (comparatorName != 0){
            return comparatorName;
        }

        return price.compareTo(product.price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
