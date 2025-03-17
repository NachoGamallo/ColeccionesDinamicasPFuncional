package org.example.Colecciones.EqualsHashCode.TEx1_ImpresoraOnline;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class AppPrinter {

    static final String ID_PC = "PC3493";
    static LinkedHashSet<PCs> PCsList = new LinkedHashSet<>();

    public static void main(String[] args) {

        System.out.println("*** BIENVENIDO A LA IMPRESORA ONLINE ***");
        AddDocument("Prueba.pdf");
        AddDocument("Prueba2.pdf");
        AddDocument("mondongo.doc");
        AddDocument("Prueba.pdF");
        AddDocument("Prueba.pdf");
        AddDocument("mammahuevo.pdf");
        AddDocument("DonPollo.pdf");
        AddDocument("MonDonGo.pdf");
        printDocument();
        System.out.println(getNumPetitions());
        System.out.println(Arrays.toString(PCsList.toArray()));
        showAll();
        printAll();

    }

    public static void AddDocument(String nameFile){

        if (nameFile.endsWith(".pdf")){

                if(PCsList.add(new PCs(ID_PC,nameFile)))

                    System.out.println("Fichero " + nameFile + " añadido a la cola de impresion.");

                else {

                    System.out.println("El archivo " + nameFile + " ya existe en la cola.");

                }

        }else {

            System.out.println("Formato del documento " + nameFile + " incorrecto.");

        }

    }

    public static void printDocument(){

        System.out.println("Imprimiendo... " + PCsList.getFirst().getName());
        PCsList.removeFirst();

    }

    public static int getNumPetitions(){

        return PCsList.size();

    }

    public static void showAll(){

        System.out.println("Cola de impresión: " + PCsList);

    }

    public static void printAll(){
        while (!PCsList.isEmpty()){

            printDocument();

        }

        System.out.println("La cola ha finalizado...");
    }

}
