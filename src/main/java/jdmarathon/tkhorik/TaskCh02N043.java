package jdmarathon.tkhorik;


public class TaskCh02N043 {
    public static void main(String[] args) {
        System.out.println("result is " + returnRequiredNumber(10, 100));
    }

    private static int returnRequiredNumber(int a, int b) {
        return ((Math.abs(a % b) * Math.abs(b % a) + 1));
    }
}