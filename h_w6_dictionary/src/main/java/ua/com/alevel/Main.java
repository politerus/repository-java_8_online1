package ua.com.alevel;



public class Main {
 public static void main(String[] args) {
  // Create a Dictionary
  Dictionary<String, Integer> dictionary = new Dictionary<>();

  // Add key-value pairs
  dictionary.put("one", 1);
  dictionary.put("two", 2);
  dictionary.put("three", 3);

  // Check size and isEmpty
  System.out.println("Size: " + dictionary.size());
  System.out.println("Is Empty: " + dictionary.isEmpty());

  // Check containsKey and containsValue
  System.out.println("Contains Key 'two': " + dictionary.containsKey("two"));
  System.out.println("Contains Value 3: " + dictionary.containsValue(3));

  // Get a value by key
  System.out.println("Value for Key 'one': " + dictionary.get("one"));

  // Remove a key-value pair
  dictionary.remove("two");
  System.out.println("After removing 'two', Size: " + dictionary.size());

  // Create another Dictionary
  Dictionary<String, Integer> anotherDictionary = new Dictionary<>();
  anotherDictionary.put("four", 4);
  anotherDictionary.put("five", 5);

  // Put all entries from another Dictionary
  dictionary.putAll(anotherDictionary);
  System.out.println("After putting all entries from another Dictionary, Size: " + dictionary.size());

  // Clear the Dictionary
  dictionary.clear();
  System.out.println("After clearing, Size: " + dictionary.size());

  // Create a new Dictionary
  Dictionary<String, Integer> newDictionary = new Dictionary<>();
  newDictionary.put("six", 6);
  newDictionary.put("seven", 7);

  // Get keySet and values
  System.out.println("Keys: " + newDictionary.keySet());
  System.out.println("Values: " + newDictionary.values());
 }
}