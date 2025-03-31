package org.example.Colecciones.P1Mercadam.Program;

import java.util.*;

public class Mercadam {

    private Set <Client> clients;

    public Mercadam(){

        this.clients = new LinkedHashSet<>();
    }

    public void addClient(Client client){
        this.clients.add(client);
    }

    public Set<Client> getClients(){
        return Collections.unmodifiableSet(this.clients);
    }

    @Override
    public String toString() {
        return "Mercadam{" +
                "clients=" + clients +
                '}';
    }
}
