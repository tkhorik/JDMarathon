package jdmarathon.tkhorik;

/*

Даны два целых числа a и b. Если a делится на b или b делится на a, то вывес-
ти 1, иначе — любое другое число. Условные операторы и операторы цикла
не использовать.

*/

public class TaskCh02N043 {
    public static void main(String[] args) {
        System.out.println("result is " + returnRequiredNumber(10, 100));
    }

    private static int returnRequiredNumber(int a, int b) {
        return ((Math.abs(a % b) * Math.abs(b % a) + 1));
    }
}