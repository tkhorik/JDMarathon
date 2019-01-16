package jdmarathon.tkhorik;


import java.util.Random;

public class TaskCh02N039 {
    private static Random rnd = new Random();

    private static double angleHour(int hours, int minutes, int sec) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            return Double.NaN;
        }
        return (double) (6 * minutes);
    }


    public static void main(String[] args) {

        int hours = rnd.nextInt(24);
        int minutes = rnd.nextInt(60);
        int seconds = rnd.nextInt(60);

        double angleFirAnswer = angleHour(hours,minutes,seconds);
        System.out.printf("Time %02d:%02d:%02d angle:%3.0f degree \n", hours, minutes,seconds, angleFirAnswer);
    }
}