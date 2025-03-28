package org.example.Colecciones.P1Mercadam;

import java.util.*;

public class Mercadam {

    private List < Client > clients;

    public Mercadam(){

        this.clients = new LinkedList<>();
    }

    public void addClient(Client client){
        this.clients.add(client);
    }

    public List < Client > getClients(){
        return Collections.unmodifiableList(this.clients);
    }

}
