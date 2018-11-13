package jdmarathon.tkhorik;

/*Дано трехзначное число(100 ≤ X ≤ 999). Найти число, полученное при прочтении его цифр справа налево.
Не использовать java.lang.String, java.lang.StringBuilder и т.п.
Только числа и арифметические операции.
Пример: 234 -> 432, 560 -> 65*/

import java.util.ArrayList;
import java.util.Scanner;

public class TaskCh02N013 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String response = "Yes";
        do {
            System.out.println("\nВведите трехачное целое число! Либо букву для прекращения программы");
            try {
                int temp = Integer.parseInt(scan.nextLine());
                ArrayList<Integer> array = new ArrayList<>();
                do {
                    array.add(temp % 10);
                    temp /= 10;
                } while (temp > 0);

                System.out.println(array);
                int sum = array.stream().mapToInt(i -> i).sum();
                System.out.println("Сумма цифр в числе:" + sum);

                int ans;
                String ansl = "";
                for (int i = 0; i < array.size(); i++) {
                    ans = array.get(i);
                    ansl = Integer.toString(ans);
                    if (ans != 0) {
                        System.out.print(ansl);
                    }
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Введено не число, программа прекращена!");
                response = "No";
            }
        } while (response.equals("Yes"));
    }
}