package jdmarathon.tkhorik.operators;


public class TaskCh04N036 {
    public static void main(String[] args) {
        System.out.println(showSemaforColor(2));
        System.out.println(showSemaforColor(4));
        System.out.println(showSemaforColor(7));
        System.out.println(showSemaforColor(57));
    }

    private static String showSemaforColor(int i) {
        if ((i % 8 >= 0) && (i % 8 < 3)) {
            return "green";
        } else if ((i % 8 >= 3) && (i % 8 < 5)) {
            return "yellow";
        } else {
            return "red";
        }
    }
}