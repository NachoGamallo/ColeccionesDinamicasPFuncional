package org.example.Colecciones.P1Mercadam.Program;

import java.util.*;

public class AppClientsArea {

    static Random random = new Random();
    static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static Client actualClient;
    static Scanner entry = new Scanner(System.in);

    public static void initiateBuy(){}

    public static void printProducts(){}

    public static void printFarewell(){}

    public static boolean authentication(Set < Client > clients, int count){

        if (count < 3){

            System.out.println("*** COMPRA ONLINE DE MERCADAM ***");
            System.out.print("Usuario: ");
            String user = entry.next();
            System.out.print("Contraseña: ");
            String password = entry.next();

            boolean status = false;
            for (Client client : clients){
                if (client.getUser().equals(user) && client.getPassword().equals(password)){
                    status = true;
                    actualClient = client;
                    break;
                }
            }
            if (status){

                System.out.println("BIENVENID@ " + actualClient.getUser());
                return true;

            }else {

                if (count == 2){

                    authentication(clients,++count);

                }else {

                    System.out.println("Algo no coincide o no existe! Vuelve a intentarlo...");
                    authentication(clients,++count);

                }

            }

        }else {

            System.out.println("ERROR DE AUTENTICACIÓN");
            return false;

        }
        return false;
    }

    public static String generatePassword(){
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8 ; i++ ){

            String temp = String.valueOf(characters.charAt(random.nextInt(characters.length())));
            password.append(temp);

        }

        return password.toString();
    }
    public static void main(String[] args) {

        Mercadam mercadam = new Mercadam();
        mercadam.addClient(new Client("nacho","12345678",null,false));
        mercadam.addClient(new Client("test",generatePassword(),null,false));
        if(authentication(mercadam.getClients(),0)){
            initiateBuy();
        }

    }
}
