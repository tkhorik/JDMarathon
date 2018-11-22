package jdmarathon.tkhorik.operators;


//4.106 Составить программу, которая в зависимости от порядкового номера ме-
//        сяца (1, 2, ..., 12) выводит на экран время года, к которому относится этот
//        месяц.
//        Использовать оператор switch.

import java.util.Scanner;

public class TaskCh04N106 {
    public static void main(String[] args) {
        MyCustomizedScanner scanner = new MyCustomizedScanner();
        StorageForScannedValue storage = new StorageForScannedValue();
        storage.setSTORAGE(scanner.scanFromConsoleAndReturnMonthName());
        new MonthAnswerGenerator().returnManthName(storage.getSTORAGE());


        new MonthAnswerGenerator().returnManthName(1);
        new MonthAnswerGenerator().returnManthName(3);
        new MonthAnswerGenerator().returnManthName(6);
        new MonthAnswerGenerator().returnManthName(9);
    }

    public static class StorageForScannedValue {
        private int STORAGE;

        public StorageForScannedValue() {

        }

        public int getSTORAGE() {
            System.out.println("из хранилища было получено значение " + STORAGE);
            return STORAGE;
        }

        public void setSTORAGE(int STORAGE) {
            System.out.println("в хранилище было отправлено число " + STORAGE);
            this.STORAGE = STORAGE;
        }

        public StorageForScannedValue(int storage) {
            STORAGE = storage;
        }
    }

    public static class MyCustomizedScanner {
        Scanner scan = new Scanner(System.in);
        String response = "Yes";


        int scanFromConsoleAndReturnMonthName() {

            System.out.println("\nВведите число! от одного до 12");
            try {
                int i = Integer.parseInt(scan.nextLine());
                System.out.print("Вы ввели:" + i + "\n");
                return i;

            } catch (NumberFormatException nfe) {
                System.err.println("Введено не число, работа сканнера прекращена!");
                response = "No";
            }
            return 0;
        }
    }

    static class MonthAnswerGenerator {
        void returnManthName(int s) {
            int intValueOfMonth = Integer.parseInt(String.valueOf(s));
            System.out.print("значение " + intValueOfMonth + " время года ");
            switch (intValueOfMonth) {
                case 2:
                case 1:
                case 12:
                    System.out.println("зима");
                    break;
                case 11:
                case 10:
                case 9:
                    System.out.println("осень");
                    break;
                case 8:
                case 7:
                case 6:
                    System.out.println("лето");
                    break;
                case 5:
                case 4:
                case 3:
                    System.out.println("весна");
                    break;
                default:
                    System.out.println("not correct month");
            }
        }
    }
}