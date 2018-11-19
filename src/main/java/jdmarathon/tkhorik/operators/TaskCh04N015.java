package jdmarathon.tkhorik.operators;

/*4.15 Известны год и номер месяца рождения человека, а также год и номер месяца
        сегодняшнего дня (январь — 1 и т. д.). Определить возраст человека (число
        полных лет). В случае совпадения указанных номеров месяцев считать, что
        прошел полный год.

        test1:
        in1 (today m y):           12 2014
        in2 (bd m y):    	        6 1985
        out:	    		 29
        test2:
        in1 (today m y):           5 2014
        in2 (bd m y):              6 1985
        out:    			 28
        test3:
        in1 (today m y):           6 2014
        in2 (bd m y):    	       6 1985
        out:    			 29*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class TaskCh04N015 {
    public static void main(String[] args) throws ParseException {

        String in1 = "5 2014";
        String in2 = "6 1985";
        String howManyYears = String.valueOf(fromStringToDateConverter(in1, in2));

        System.out.println("Возраст человека: " + howManyYears);
    }


    private static Date convertedTodateToConvert(String in1) throws ParseException {
        DateFormat dateToConvert = new SimpleDateFormat("MM yyyy");
        return dateToConvert.parse(in1);
    }

    private static LocalDate convertToLocalDateInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static int fromStringToDateConverter(String in1, String in2) throws ParseException {
        return Period.between(convertToLocalDateInstant(convertedTodateToConvert(in2)),
                convertToLocalDateInstant(convertedTodateToConvert(in1))).getYears();
    }
}
