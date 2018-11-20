package jdmarathon.tkhorik.operators;

//
//4.36 Работа светофора для пешеходов запрограммирована следующим образом: в
//        начале каждого часа в течение трех минут горит зеленый сигнал, затем в те-
//        чение двух минут — красный, в течение трех минут — опять зеленый и т. д.
//        Дано вещественное число t, означающее время в минутах, прошедшее с нача-
//        ла очередного часа. Определить, сигнал какого цвета горит для пешеходов в
//        этот момент.
//
//        test1:
//        in:    3
//        out: red
//        test2:
//        in:    5
//        out: green
//

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