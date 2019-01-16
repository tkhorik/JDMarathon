package jdmarathon.tkhorik;

import java.util.Scanner;


public class TaskCh01N003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String response = "Yes";
        do {
            System.out.println("\nВведите число!");
            try {
                int i = Integer.parseInt(scan.nextLine());
                System.out.print("Вы ввели:" + i);
            } catch (NumberFormatException nfe) {
                System.err.println("Введено не число, программа прекращена!");
                response = "No";
            }
        } while (response.equals("Yes"));
    }
}