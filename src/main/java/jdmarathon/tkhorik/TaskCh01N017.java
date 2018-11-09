package jdmarathon.tkhorik;

import java.util.Scanner;


//*Записать по правилам языка java следующие выражения:
//Использовать методы класса java.lang.Math.*/

public class TaskCh01N017 {
    public static void main(String[] args) {
        double x = 0;
//solution o
        double o = Math.sqrt(1 - Math.pow(Math.sin(x), 2));

//solution p
        double p = (Math.sqrt(x + 2) + Math.sqrt(x - 1)) / 2 * Math.sqrt(x);

//solution n
        double a = 0;
        double b = 0;
        double c = 0;
        double n = 1 / Math.sqrt((Math.pow(a * x, 2) + b * x + c));

//solution c
        double cc = Math.abs(x) + Math.abs(x + 1);
    }
}