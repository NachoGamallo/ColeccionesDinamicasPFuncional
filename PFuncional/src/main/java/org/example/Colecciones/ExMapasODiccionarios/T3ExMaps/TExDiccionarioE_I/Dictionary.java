package org.example.Colecciones.ExMapasODiccionarios.T3ExMaps.TExDiccionarioE_I;

import java.util.*;

public class Dictionary {

    Map<String , String> dictionary;
    static Random random = new Random();
    static Scanner entry = new Scanner(System.in);

    public Dictionary (){

        this.dictionary = new HashMap<>();

    }

    public void newWords(String spanishWord, String englishWord){dictionary.put(spanishWord,englishWord);}

    private String traduce(String spanishWord){

        if (dictionary.containsKey(spanishWord)){

            return dictionary.get(spanishWord);

        }else {

            System.out.println("La palabra introducida no existe en el diccionario.");
            return null;
        }

    }

    private String randomWord(){

        int randomPoss = random.nextInt(dictionary.size());
        String[] keys = dictionary.keySet().toArray(new String[0]);
        System.out.println(Arrays.toString(keys));
        return keys[randomPoss];

    }

    private Character firstLetterEnglish(String spanishWord){

        return dictionary.get(spanishWord).charAt(0);
    
    }

    public void questionnaire(){

        String userEntry;
        int totalQuestions = 0;
        int totalGoodAnswer = 0;
        int totalBadAnswer = 0;

        do {

            String wordToTraduce = randomWord();
            System.out.print(wordToTraduce + ":");
            System.out.println(firstLetterEnglish(wordToTraduce + "..."));
            System.out.println("Indique la respuesta:");
            userEntry = entry.next();

            if (!userEntry.equalsIgnoreCase("fin")){
                totalQuestions++;
                if (dictionary.get(wordToTraduce).equalsIgnoreCase(userEntry)){
                    System.out.println("CORRECTO!!");
                    totalGoodAnswer++;
                }else {
                    System.out.print("NO!! ");
                    System.out.println("La respuesta correcta es " + dictionary.get(wordToTraduce));
                    totalBadAnswer++;
                }
            }

            System.out.println("FIN DEL PROGRAMA");
            System.out.println("Total preguntas: " + totalQuestions);
            System.out.println("Total aciertos: " + totalGoodAnswer);
            System.out.println("Total errores: " + totalBadAnswer);
            System.out.println("Aciertos: " + (totalQuestions/totalGoodAnswer*100));
        }while (!userEntry.equalsIgnoreCase("fin"));
    }
}
