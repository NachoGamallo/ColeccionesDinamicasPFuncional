package org.example.Colecciones.P1Mercadam.Program;

import java.util.*;

/**
 * Esta es la aplicacion principal, que se encarga de llamar a los respectivos objetos para realizar las
 * funcionalidades de nuestros menús con diferentes opciones (Productos, descuentos, ingreso a la orden de pedido...).
 * @author Nacho Gamallo estudiante 1DAM en IES MUTXAMEL.
 * @version 1.0
 */
public class AppClientsArea {

    static Random random = new Random();
    static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static Client actualClient;
    static Scanner entry = new Scanner(System.in);

    /**
     * Función para limpiar la pantalla al ejecutar en la consola de Windows.
     */
    public static void clearConsole() throws InterruptedException {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        Thread.sleep(200);
    }

    /**
     * Este método es la ejecucción principal del programa (main), va a generar la orden del cliente si no existe ya,
     * después va a solicitar al usuario que introduzca un producto para agregar a su "carrito" , antes de solicitarlo
     * va a imprimir la lista de productos con su respectivo precio, por ultimo verifíca si el producto que
     * a introducido exíste, si no es el caso volvera a ejecutar este método.
     * @see Client#insertProduct(String)
     * @see Client#getOrder()
     * @see Client#createOrder()
     * @see #printProducts()
     */
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

    /**
     * Este método va a imprimir toda la lista de los productos disponibles a la venta,
     * con el formáto especifico que sse indica.
     */
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

    /**
     * Metodo de déspedida , cuando se el cliente no quiere usar más la App y tiene el pedido ya completado.
     */
    public static void printFarewell(){
        System.out.println("GRACIAS POR SU PEDIDO. Se lo mandaremos a la direccion " + actualClient.getAddress());
    }

    /**
     *Cuando el cliente ya no quiere agregar ningún producto, sacaremos este menú con diferentes opciónes ,
     * podrá aplicar descuentos , mostrar resumen de productos ordenado por unidades o terminar el pedído.
     * @see #afterBuyMenu(String)
     */
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

    /**
     * Este representa el menú , a nivel de código que se le da al usuario antes de acabar el proceso del pedido.
     * @see Client#applyPromo() - Aplicar promociones en el cliente.
     * @see Client#productsResume() Resumen de los productos.
     * @see Client#sortedProductsList() Lista de productos ordenada por catidad.
     * @see #printFarewell() Despedida para el usuario.
     * @param option Parametro pasado por el usuario, que nos indica que opcion queremos hacer: Aplicar promo,
     *               ordenar productos o salir
     * @return Nos devuelve false, si el usuario esta seleccionando una opción que no sea la de salir,
     * true si quiere acabar la operación
     */
    public static boolean afterBuyMenu(String option){

        switch (option) {
            case "1" -> {
                actualClient.applyPromo();
                actualClient.productsResume();
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

    /**
     * Esta función se va a ocupar de autentificar que el usuario/contraseña sean correctas según el contenido de la
     * lista de usuarios del objeto Mercadam, el usuario podrá fallar la contraseña un número limitado de veces (3) y le
     * sacará del programa si esto ocurre.
     * Esto lo conseguimos recorriendo el Set de Clientes y comparando valores.
     * @param clients Lista Set (lista única, Set) de clientes
     * @return Si encuentra el usuario / contraseña nos devolvera true para que el programa siga avanzando. Si falla 3
     * veces y aún no se ha ingresado un usuario correcto nos dara false y el programa nos sacará.
     */
    public static boolean authentication(Set < Client > clients) throws InterruptedException {

        int count = 0;
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

    /**
     * Con esta función vamos a generar una contraseña aleatoria , teniendo en cuenta los
     * caracteres de la variable characters.
     * Tendrá una longitud de 8 la contraseña.
     * @return Nos devuelve la contraseña que hemos generado en la función.
     */
    public static String generatePassword(){
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8 ; i++ ){

            String temp = String.valueOf(characters.charAt(random.nextInt(characters.length())));
            password.append(temp);

        }

        System.out.println(password);
        return password.toString();
    }

    /**
     * Main , en el que ejecutamos el sistema de compras. Aqui crearemos Mercadam y daremos de alta a los a
     * clientes que se den de alta.
     * @see #initiateBuy() Inicio de pago.
     * @see #afterBuyPrint() Una vez ya hemos seleccionado los productos que queremos.
     * @see #authentication(Set) Funcion para verificar el usuario.
     */
    public static void main(String[] args) throws InterruptedException {

        Mercadam mercadam = new Mercadam();
        mercadam.addClient(new Client("nacho","12345678",null,true));
        mercadam.addClient(new Client("test",generatePassword(),null,false));
        mercadam.addClient(new Client("Angel",generatePassword(),null,true,"Calle del badulaque"));

        if(authentication(mercadam.getClients())){

            initiateBuy();
            afterBuyPrint();

        }
    }
}