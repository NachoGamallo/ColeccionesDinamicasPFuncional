package org.example.Colecciones.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPruebas {
    public static void main(String[] args) {

        Stream<Integer> numeros = Stream.of(1,2,3,4,5);

        List<Integer> numerosList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,22,22,12,5,12,43));

         long filtrados = numerosList.stream().filter(nums -> nums > 10).distinct().count();
        System.out.println(filtrados);

         List<String> pueblos = new ArrayList<>(Arrays.asList("Elche","San Vicente","Mutxamel","Eliana"));

         pueblos.stream().map(String::toUpperCase).filter(pueblo -> pueblo.contains("I")).filter(pueblo -> pueblo.endsWith("A")).forEach(System.out::println);
    }

}
