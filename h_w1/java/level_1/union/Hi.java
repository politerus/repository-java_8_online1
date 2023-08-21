public class Hi {

    public static void main(String[] args) {
        Message my = new Message();
        byte b = Byte.MAX_VALUE;
        byte b1 = Byte.MIN_VALUE;
        short s = Short.MAX_VALUE;
        int a = Integer.MAX_VALUE;
        long l = Long.MAX_VALUE;
        my.print(String.valueOf(b));
        my.print(String.valueOf(b1));
        my.print(String.valueOf(s));
        my.print(String.valueOf(a));
        my.print(String.valueOf(l));
    }
}