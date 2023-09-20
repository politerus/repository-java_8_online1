package ua.com.alevel;

public class ReverseStringLibrary {

    public static String reverse(String src) {
        return new StringBuilder(src).reverse().toString();
    }

    public static String reverseSubstring(String src, int startIndex, int endIndex) {
        if (src == null || startIndex < 0 || endIndex >= src.length()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        String substring = src.substring(startIndex, endIndex + 1);
        return reverse(substring);
    }

    public static String reverseSubstring(String src, String start, String end) {
        if (src == null || start == null || end == null) {
            throw new IllegalArgumentException("Source, start, and end strings cannot be null");
        }

        int startIndex = src.indexOf(start);
        int endIndex = src.lastIndexOf(end);

        if (startIndex == -1 || endIndex == -1 || startIndex > endIndex) {
            return src;
        }

        String prefix = src.substring(0, startIndex);
        String substring = src.substring(startIndex, endIndex + end.length());
        String suffix = src.substring(endIndex + end.length());

        return prefix + reverse(substring) + suffix;
    }


}
