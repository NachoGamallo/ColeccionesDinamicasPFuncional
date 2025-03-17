package org.example.Colecciones.EqualsHashCode;

import java.util.LinkedHashSet;

public class Pruebas {

    public static void main(String[] args) {

        Paciente raul = new Paciente ("123456", "Raul" ,"Garcia Delgado");
        Paciente xavi = new Paciente("654321","Javier","Cervera Lillo");
        Paciente javi = new Paciente("654321","Javier","Cervera Lillo");

        LinkedHashSet <Paciente> listaPacientes = new LinkedHashSet<>();
        listaPacientes.add(raul);
        listaPacientes.add(xavi);
        listaPacientes.add(javi);

        System.out.println(javi.hashCode());
        System.out.println(xavi.hashCode());
        System.out.println(listaPacientes);
    }

}
