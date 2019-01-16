package jdmarathon.tkhorik;

public class Recursion {
    static int factorial(int n) {
        if (n != 0)
            return n * factorial(n - 1); // recursive call
        else
            return 1;
    }

    public static void main(String[] args) {
        int number = 12, result;
        result = factorial(number);
        System.out.println(number + " factorial = " + result);

        matrioshca(5);
    }

    private static void matrioshca(int n) {
        if (n == 1) {
            System.out.println("матрешечка");
        } else {
            System.out.println("верх " + n);
            matrioshca(n - 1);
            System.out.println("низ " + n);
        }
    }
}