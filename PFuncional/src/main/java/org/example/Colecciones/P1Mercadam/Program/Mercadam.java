package org.example.Colecciones.P1Mercadam.Program;

import lombok.ToString;
import java.util.*;

@ToString
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

}
