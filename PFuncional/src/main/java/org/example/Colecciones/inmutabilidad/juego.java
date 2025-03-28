package org.example.Colecciones.inmutabilidad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class juego {

    private String name;
    private int level;
    private List<String> champList;

    public juego(String name, int level){
        this.name = name;
        this.level = level;
        champList = new ArrayList<>();
    }

    public List<String> getChampList() {
        return Collections.unmodifiableList(champList);
    }

    @Override
    public String toString() {
        return "juego{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", champList=" + champList +
                '}';
    }
}
