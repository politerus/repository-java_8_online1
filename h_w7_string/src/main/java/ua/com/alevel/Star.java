package ua.com.alevel;

import static ua.com.alevel.ReverseStringLibrary.reverse;
import static ua.com.alevel.ReverseStringLibrary.reverseSubstring;

public class Star {
    public static void main(String[] args) {

        String input = "hello world";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverse(input));

        String input2 = "hello world, world";
        System.out.println("Original: " + input2);
        System.out.println("Reversed substring: " + reverseSubstring(input2, 6, 11));

        String input3 = "hello world, start, end";
        System.out.println("Original: " + input3);
        System.out.println("Reversed substring: " + reverseSubstring(input3, "start", "end"));
    }
}