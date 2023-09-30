package ua.com.alevel;

public class StringReverser {

    public static String reverse(String src) {
        char[] chars = src.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return new String(chars);
    }

    public static String reverse(String src, String dest) {
        if (src.contains(dest)) {
            int startIndex = src.indexOf(dest);
            int endIndex = startIndex + dest.length();
            String before = src.substring(0, startIndex);
            String after = src.substring(endIndex);
            return before + reverse(dest) + after;
        } else {
            return src;
        }
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < src.length() && firstIndex <= lastIndex) {
            String before = src.substring(0, firstIndex);
            String substringToReverse = src.substring(firstIndex, lastIndex + 1);
            String after = src.substring(lastIndex + 1);
            return before + reverse(substringToReverse) + after;
        } else {
            return src;
        }
    }
}