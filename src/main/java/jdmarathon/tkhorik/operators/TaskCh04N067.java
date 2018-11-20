package jdmarathon.tkhorik.operators;

//4.67 Дано целое число k (1≤ k ≤ 365). Определить, каким будет k-й день года: вы-
//        ходным (суббота и воскресенье) или рабочим, если 1 января — понедельник.
//        test1 - in: 5; out: Workday
//        test2 - in: 7; out: Weekend

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