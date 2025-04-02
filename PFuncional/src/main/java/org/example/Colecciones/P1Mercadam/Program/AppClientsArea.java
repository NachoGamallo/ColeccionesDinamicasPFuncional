package org.example.Colecciones.P1Mercadam.Program;

import java.util.*;

public class AppClientsArea {

    static Random random = new Random();
    static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static Client actualClient;
    static Scanner entry = new Scanner(System.in);

    public static void clearConsole() throws InterruptedException {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        Thread.sleep(200);
    }
    public static void initiateBuy(){

        if (actualClient.getOrder() == null){
            actualClient.createOrder();
        }
        System.out.println("Añade productos a tu lista de la compra...");
        printProducts();
        System.out.print("    Elige un producto:");
        if (!actualClient.insertProduct(entry.next())){
            initiateBuy();
        }

    }

    public static void printProducts(){

        int lastEnum = Product.values().length - 1;
        int temp = 0;

        System.out.println("====================================");

        for (Product p : Product.values()){

            System.out.print("    " + p + " precio (" + p.getPrice() + "€)");
            System.out.println(temp < lastEnum ? "," : ";");
            temp++;

        }

        System.out.println("====================================");

    }

    public static void printFarewell(){}

    public static boolean authentication(Set < Client > clients, int count) throws InterruptedException {

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

                System.out.println("BIENVENID@ " + actualClient.getUser() + "!");
                clearConsole();
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

    public static void main(String[] args) throws InterruptedException {

        Mercadam mercadam = new Mercadam();
        mercadam.addClient(new Client("nacho","12345678",null,false));
        mercadam.addClient(new Client("test",generatePassword(),null,false));

        if(authentication(mercadam.getClients(),0)){

            initiateBuy();

        }
    }
}
