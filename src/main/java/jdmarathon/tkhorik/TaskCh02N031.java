package jdmarathon.tkhorik;


public class TaskCh02N031 {
    public static void main(String[] args) {
        {
            int initial;
            initial = getRandomDoubleBetweenRange(100, 999);
            System.out.println("было загадано первоначально число: " + initial);
            int generatedNewN = generateNewNDigit(initial);
            System.out.println("Измененное число N " + generatedNewN);
            System.out.println("первоначально загаданное число Х: " + reverseGeneratedInt(generatedNewN));

        }
    }

    private static String reverseGeneratedInt(int generatedNewNvalue) {
        int a = generatedNewNvalue / 100;
        int b = generatedNewNvalue / 10 % 10;
        int c = generatedNewNvalue % 10;
        String result = "" + a + c + b;  //-second variat to return statement
        return result;
    }

    private static int generateNewNDigit(int initial) {
        int a = initial / 100;
        int b = initial / 10 % 10;
        int c = initial % 10;
        int k = Integer.valueOf(String.valueOf(a) + String.valueOf(c) + String.valueOf(b));
        return k;
    }

    private static int getRandomDoubleBetweenRange(double min, double max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}

