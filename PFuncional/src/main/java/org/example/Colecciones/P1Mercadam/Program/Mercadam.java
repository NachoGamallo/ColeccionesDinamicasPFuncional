package org.example.Colecciones.P1Mercadam.Program;

import lombok.ToString;
import java.util.*;

@ToString
/**
 * Clase que gestiona la lista de los empleados dados de alta.
 * @author Nacho Gamallo estudiante 1DAM en IES MUTXAMEL.
 * @version 1.0
 */
public class Mercadam {

    private final Set <Client> clients;

    /**
     * Constructor de Mercadam
     */
    public Mercadam(){

        this.clients = new LinkedHashSet<>();
    }

    /**
     * Este método sirve para agregar clientes a la lista de clientes únicos.
     * @param client Cliente el cual vamos a ingresar a la lista.
     */
    public void addClient(Client client){
        this.clients.add(client);
    }

    /**
     * Nos devuelve la lista de clientes.
     * @return Nos devuelve los clientes, sin que nadie pueda modificarlos.
     */
    public Set<Client> getClients(){
        return Collections.unmodifiableSet(this.clients);
    }

}
