package jdmarathon.tkhorik.operators;


public class TaskCh04N033 {
    public static void main(String[] args) {
        int a = 92764510;
        int b = 192984457;
        System.out.println("число " + a + ifTheLastDigitFromIntegerIsOdd(a));
        System.out.println("число " + b + ifTheLastDigitFromIntegerIsOdd(b));
    }

    private static String ifTheLastDigitFromIntegerIsOdd(int x) {
        if (x % 10 % 2 == 0) {
            return " заканчивается четной цифрой";
        }
        return " заканчивается НЕ четной цифрой";
    }
}