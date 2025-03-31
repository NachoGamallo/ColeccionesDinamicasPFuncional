package org.example.Colecciones.P1Mercadam.Program;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AppClientsArea {

    static Random random = new Random();
    static Client client;
    static Scanner entry = new Scanner(System.in);

    public static void initiateBuy(){}

    public static void printProducts(){}

    public static void printFarewell(){}

    public static void authentication(List < Client > clients){
        System.out.println("*** COMPRA ONLINE DE MERCADAM ***");
        System.out.print("Usuario: ");
        String user = entry.next();
        System.out.print("Contraseña: ");
        String password = entry.next();

        boolean status = false;
        for (Client client : clients){
            if (client.getUser().equals(user) && client.getPassword().equals(password)){
                status = true;
                break;
            }
        }
        if (status){
            System.out.println("El usuario si existe.");
        }else {
            System.out.println("El usuario no existe.");
        }
    }
    public static void main(String[] args) {

        Mercadam mercadam = new Mercadam();
        mercadam.addClient(new Client("nacho","12345678",null,false));
        authentication(mercadam.getClients());

    }
}
