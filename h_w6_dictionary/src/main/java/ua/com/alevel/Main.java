package ua.com.alevel;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
       Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("one", 1);
        dictionary.put("two", 2);
        dictionary.put("three", 3);

        Collection<Integer> allValues = dictionary.values();
        System.out.println("All values:");
        for (Integer value : allValues) {
            System.out.println(value);
        }

        System.out.println("Size: " + dictionary.size());

        System.out.println("Is empty: " + dictionary.isEmpty());

        System.out.println("Contains key 'two': " + dictionary.containsKey("two"));

        System.out.println("Contains value 4: " + dictionary.containsValue(4));

        System.out.println("Value for key 'one': " + dictionary.get("one"));

        dictionary.remove("three");
        System.out.println("After removing 'three', size: " + dictionary.size());

        Dictionary<String, Integer> anotherDictionary = new Dictionary<>();
        anotherDictionary.put("four", 4);
        anotherDictionary.put("five", 5);

        dictionary.putAll(anotherDictionary);
        System.out.println("After putting all elements from another dictionary, size: " + dictionary.size());

        dictionary.clear();
        System.out.println("After clearing, size: " + dictionary.size());
    }
}