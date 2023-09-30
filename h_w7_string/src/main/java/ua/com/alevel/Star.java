package ua.com.alevel;


import static ua.com.alevel.StringReverser.reverse;

public class Star {
    public static void main(String[] args) {
        String input = "hello world";
        String substring = "worl";


        String reversed1 = reverse(input);
        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reversed1);


        String reversed2 = reverse(input, substring);
        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reversed2);


        String reversed3 = reverse(input, 3, 7);
        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reversed3);
    }
}