package org.example.Colecciones.ExMapasODiccionarios.T3ExMaps.TExDiccionarioE_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dictionary {

    Map<String , String> dictionary;
    static Random random = new Random();

    public Dictionary (){

        this.dictionary = new HashMap<>();

    }

    public void newWords(String spanishWord, String englishWord){dictionary.put(spanishWord,englishWord);}

    public void traduce(String spanishWord){

        if (dictionary.containsKey(spanishWord)){

            dictionary.get(spanishWord);

        }else {

            System.out.println("La palabra introducida no existe en el diccionario.");

        }

    }

    public String randomWord(){

        int randomPoss = random.nextInt(dictionary.size());
        String[] keys = dictionary.keySet().toArray(new String[0]);
        return keys[randomPoss];

    }

    public Character firstLetterEnglish(String spanishWord){

        return dictionary.get(spanishWord).charAt(0);
    
    }
}
