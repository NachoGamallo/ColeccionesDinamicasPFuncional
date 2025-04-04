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

    public static void printFarewell(){
        System.out.println("GRACIAS POR SU PEDIDO. Se lo mandaremos a la direccion " + actualClient.getAddress());
    }

    public static void afterBuyPrint(){

        System.out.println("=======================================");
        System.out.println("QUE DESEA HACER?");
        System.out.println("[1]. Aplicar promo");
        System.out.println("[2]. Mostrar resumen ordenado por uds.");
        System.out.println("[3]. Terminar pedido");
        System.out.println("=======================================");
        System.out.print("Eige una opcion: ");
        if (!afterBuyMenu(entry.next())){
            afterBuyPrint();
        }

    }

    public static boolean afterBuyMenu(String option){

        switch (option) {
            case "1" -> {
                actualClient.applyPromo();
                actualClient.ProductsResume();
                return false;
            }
            case "2" -> {
                actualClient.sortedProductsList();
                return false;
            }
            case "3" -> {
                printFarewell();
                return true;
            }
            default -> {
                System.out.println("Ha introducido una opcion que no esta en el menu...");
                return false;
            }
        }
    }

    public static boolean authentication(Set < Client > clients, int count) throws InterruptedException {

        while (count < 3){

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

                count++;
                if (count < 3){

                    System.out.println("Algo no coincide o no existe! Vuelve a intentarlo...");

                }
            }
        }

        System.out.println("ERROR DE AUTENTICACIÓN");
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
        mercadam.addClient(new Client("nacho","12345678",null,true));
        mercadam.addClient(new Client("test",generatePassword(),null,false));

        if(authentication(mercadam.getClients(),0)){

            initiateBuy();
            afterBuyPrint();

        }
    }
}
