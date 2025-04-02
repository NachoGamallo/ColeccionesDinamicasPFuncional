package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;

@Getter
public enum Product {

    MANZANAS(2.30),
    PAN(1.00),
    ARROZ(3.50),
    POLLO(4.30),
    LECHE(1.30),
    ACEITE(8.30),
    HUEVOS(3.30),
    TOMATES(4.00),
    PASTA(0.89);

    private final double price;


    Product(double price) {
        this.price = price;
    }

}
