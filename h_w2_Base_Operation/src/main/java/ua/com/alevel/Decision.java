package ua.com.alevel;

import java.util.Map;
import java.util.TreeMap;

public class Decision {
    public static String getNumber(String line) {
        int sumNumbers = 0;
        for (int i = 0; i < line.length(); i++) {
            //проверяю, является ли символ с индексом i в строке line цифрой
            if (Character.isDigit(line.charAt(i))) {
                sumNumbers += Character.getNumericValue(line.charAt(i));
            }//if
        }//for
        return String.valueOf(sumNumbers);
    }//public static String getNumber

    public static void getLetters(String line) {
        Map<Character, Integer> charCountMap = new TreeMap<>();
       //  проверяю, является ли текущий символ  буквой.
        for (char letters : line.toCharArray()) {
            //если буква в верхнем реестре преобразую ее в нижний реестр
            //с помощью  toLowerCase
            if (Character.isLetter(letters)) {
                letters = Character.toLowerCase(letters);
                //отслеживаю количество каждого символа в строке letters
                charCountMap.put(letters, charCountMap.getOrDefault(letters, 0) + 1);
            }
        }
        //счетчик
        int counter = 1;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.printf(counter + "," + " " + entry.getKey() + " - " + entry.getValue() + " ");
            counter++;
        }
    }
}
