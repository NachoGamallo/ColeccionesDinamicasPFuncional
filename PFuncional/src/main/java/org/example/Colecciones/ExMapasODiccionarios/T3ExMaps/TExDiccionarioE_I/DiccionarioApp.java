package org.example.Colecciones.ExMapasODiccionarios.T3ExMaps.TExDiccionarioE_I;

public class DiccionarioApp {

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        dictionary.newWords("Perro","Dog");
        dictionary.newWords("Tabla","Table");

        dictionary.questionnaire();
    }

}
