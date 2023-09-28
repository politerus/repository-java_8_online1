package ua.com.alevel;

import java.util.Collection;
import java.util.Set;

public class Main {
 public static void main(String[] args) {
  Dictionary<String, Integer> dictionary = new Dictionary<>();

  dictionary.put("one", 1);
  dictionary.put("two", 2);
  dictionary.put("three", 3);


  Set<String> keys = dictionary.keySet();
  Collection<Integer> values = dictionary.values();

  System.out.println("Keys: " + keys);
  System.out.println("Values: " + values);

  System.out.println("Size: " + dictionary.size());

  System.out.println("Is empty: " + dictionary.isEmpty());

  System.out.println("Contains key 'two': " + dictionary.containsKey("two"));
  System.out.println("Contains value 4: " + dictionary.containsValue(4));

  System.out.println("Value for key 'two': " + dictionary.get("two"));

  Dictionary<String, Integer> anotherDictionary = new Dictionary<>();
  anotherDictionary.put("four", 4);
  anotherDictionary.put("five", 5);
  dictionary.putAll(anotherDictionary);

  System.out.println("Updated Dictionary: " + dictionary);

  dictionary.remove("three");

  System.out.println("Size after removing 'three': " + dictionary.size());

  dictionary.clear();

  System.out.println("Size after clearing: " + dictionary.size());
 }
}