package org.example.Colecciones.EqualsHashCode.TEx3_TareasDeFuncionamiento;

import java.util.HashSet;
import java.util.Stack;

public class AppFunctions {

    static Stack < Reports > reportsStack = new Stack<>();
    static HashSet < Reports > reportsHashSet = new HashSet<>();

    public static void main(String[] args) {

        Reports report1 = new Reports(1,"Mondongo",Type.ADMINISTRATIVO);
        Reports report2 = new Reports(1,"Mondongo",Type.EMPRESARIAL);
        Reports report3 = new Reports(2,"Mondongo",Type.PERSONAL);
        Reports report4 = new Reports(1,"Mondongo",Type.ADMINISTRATIVO);
        Reports report5 = new Reports(2,"Mondongo",Type.EMPRESARIAL);

        operateReports();

        Reports reports = new Reports(2,"Mondongo",Type.ADMINISTRATIVO);
        reportsHashSet.add(reports);
        Reports reports6 = new Reports(1,"Mondongo",Type.PERSONAL);
        reportsHashSet.add(reports6);
        Reports reports7 = new Reports(2,"Mondongo",Type.EMPRESARIAL);
        reportsHashSet.add(reports7);
        Reports reports8 = new Reports(2,"Mondongo",Type.ADMINISTRATIVO);
        reportsHashSet.add(reports8);

        printReports();
        System.out.println(reportsHashSet.size());

    }

    public static void operateReports(){

        System.out.println(" === DESPACHANDO INFORMES ===");

        while (!reportsStack.isEmpty()){
            System.out.println("Despachando.... " + reportsStack.pop());
        }
        System.out.println("\n");
    }

    public static void printReports(){

        System.out.println(" === IMPRIMIENDO LISTA ===");

        for ( int i = reportsStack.size()-1 ; i >= 0 ; i -- ) {

            System.out.println("Imprimiendo... " + reportsStack.get(i));

        }
    }

    public static void totalReports(){

        while (!reportsHashSet.isEmpty()){
            int temp = 0;

            for (Reports rep : reportsStack){
                if (reportsHashSet.remove()){

                }
            }
        }

    }
}
