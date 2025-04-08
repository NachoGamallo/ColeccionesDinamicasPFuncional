package org.example.Colecciones.P1Mercadam.Program;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;
import java.util.Scanner;

/**
 * Este es el objeto donde almacenamos toda la informacion de los clientes,
 * y su funcionamiento con el sistema, son un punto clave en esta App
 * @author Nacho Gamallo estudiante 1DAM en IES MUTXAMEL.
 * @version 1.0
 */

@Getter
@ToString
@Setter
public class Client {

    static Scanner entry = new Scanner(System.in);

    final String FALSE_ADDRESS = "CALLE FALSA, 123";
    private String user;
    private String password;
    private Order order;
    private boolean promo;
    private String address;


    /**
     * Constructor de Cliente, con la direccion por defecto.
     * @param user Clave del usuario
     * @param password Contraseña de acceso del ususario
     * @param order Pedido que tiene este usuario.
     * @param promo Indicador de si tiene o no disponible una promoción.
     */
    public Client(String user, String password, Order order, boolean promo){

        this.user = user;
        this.password = password;
        this.order = order;
        this.promo = promo;
        this.address = FALSE_ADDRESS;

    }

    /**
     * Constructor de Cliente, con la direccion indicada por el usuario.
     * @param user Clave del usuario
     * @param password Contraseña de acceso del ususario
     * @param order Pedido que tiene este usuario.
     * @param promo Indicador de si tiene o no disponible una promoción.
     * @param address Direccion del Cliente.
     */
    public Client(String user, String password, Order order, boolean promo, String address){

        this.user = user;
        this.password = password;
        this.order = order;
        this.promo = promo;
        this.address = address;

    }

    /**
     * Con este método vamos a crear un order para este Cliente en especifico.
     * El planning es que por defecto llegue null, y cuando el usuario consigue acceder. Creamos el Order.
     */
    public void createOrder(){

        this.order = new Order();

    }

    /**
     * Este menú vendrá después de la lista de productos, y tenemos que introducir el producto que queremos agregar
     * a nuestro pedido. Recorreremos todos los productos y si no existe la funcion devuelve false.
     * Por lo contrario si lo encuentra agregara el producto a el Pedido , indicara el precio de este y el importe total del carrito.
     * También preguntará al usuario si quiere seguir con su pedido.
     * @see Order#addProduct(Product, Integer) Agregamos un producto a la Order.
     * @see #orderAmount() Importe total del carrito.
     * @see #optionOrder() Indica si el cliente quiere seguir comprando productos o no.
     * @param userProduct Producto el cual el usuario quiere introducir en su Pedido.
     * @return Dependiendo si existe o no el producto indicado , devolvera true o false.
     */
    public boolean insertProduct(String userProduct){

        System.out.println("====================================");

        for (Product p : Product.values()){
            if (userProduct.equalsIgnoreCase(p.toString())){
                this.order.addProduct(p,1);

                System.out.println("Has añadido " + p + " con un precio de " + p.getPrice() + " €. Importe total del carrito: "
                        + String.format("%.2f",orderAmount()) + "€. Quieres añadir mas productos a tu carrito de la compra? [S/N]");
                return optionOrder();
            }
        }

        System.out.println("El producto no existe! Elige otro.");
        return false;
    }

    /**
     * Esta funcion devolvera la opcion del cliente, si quiere o no seguir comprando productos. Si indicamos algo que no debemos
     * nos volverá a pedir el parametro correcto S (seguir comprando) N (No comprar más).
     * @see #productsResume() Resumen de productos del pedido.
     * @return Nos devolvera un valor booleano dependiendo de la opción que elijamos.
     */
    private boolean optionOrder(){

        while (true){

            String option = entry.next().toUpperCase();

            switch (option){
                case "S":
                    return false;

                case "N":
                    productsResume();
                    return true;

                default:
                    System.out.println("Opcion no valida, introduce una opcion correcta [S/N]");
            }
        }
    }

    /**
     * Bucle en una sola linea, sin necesidad de for usamos stream para recorrer el Map, convertimos
     * la key (Producto y obtenemos el precio de este) * value (Integer , num de productos) y hacemos la suma de todas las lineas
     * de nuestra order.
     * @return Devuelve el valor total, tras recorrer todo el Map.
     */
    public double orderAmount(){
        return this.order.productsList.entrySet().stream()
                .mapToDouble(line -> (line.getKey().getPrice()*line.getValue())).sum();
    }

    /**
     * Este método nos va a imprimir el menú de post Selección de Productos.
     * Vamos a imprimir un resumen de cantidad + nombre Producto + Precio, de nuestra Order.
     * @see #orderAmount() Valor total de el carrito, lo define si esta por defecto.
     * @see Order#getTotalAmount() Nos va a imprimir el valor del total de la Order.
     */
    public void productsResume(){

        System.out.println("=====================================");
        System.out.println("RESUMEN DE TU CARRITO DE LA COMPRA:");

        this.order.getProducts();

        if (order.totalAmount == order.DEFAULT_VALUE){
            this.order.totalAmount = orderAmount();
        }


        System.out.println("IMPORTE TOTAL: " + String.format("%.2f", this.order.getTotalAmount()));

    }

    /**
     * Función getter de Promo.
     * @return Nos devuelve promo
     */
    public boolean getPromo(){
        return this.promo;
    }

    /**
     * Este método lo usaremos de intermediario para acceder a Orders desde AppClientsArea.
     * @see Order#checkClientPromo(Client) Promoción de un cliente en específico.
     */
    public void applyPromo(){
        this.order.checkClientPromo(this);
    }

    /**
     * Hacemos lo mismo que applyPromo, intermediarios entre la App y order.
     * @see Order#getSortedProducts() Productos ordenados por cantidad.
     */
    public void sortedProductsList(){order.getSortedProducts();}

    /**
     * Esto lo usamos para verificar que en la lista de Clientes no tenemos repetidos, filtrando por user-password.
     * @param o Objeto que pasaremos , en este caso Cliente.
     * @return Nos devuelve la condicion, si es cumplida o no.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(user, client.user) && Objects.equals(password, client.password);
    }

    /**
     * Comprobar el hash de un objeto. Para verificar que no se repite.
     * @return Nos devuelve el valor númerico del Objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

}
