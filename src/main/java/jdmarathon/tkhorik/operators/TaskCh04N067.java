package jdmarathon.tkhorik.operators;


public class TaskCh04N067 {
    public static void main(String[] args) {
        System.out.println(whatWeekDayIs(5));
        System.out.println(whatWeekDayIs(7));
        System.out.println(whatWeekDayIs(380));
    }

    private static String whatWeekDayIs(int i) {
        if ((i > 0) && (i < 366)) {
            if ((i % 7 >= 5) && (i % 7 < 6)) {
                return "Workday";
            } else {
                return "Weekend";
            }
        }
        return "не входит в интервал";
    }
}