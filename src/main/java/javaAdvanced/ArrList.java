package javaAdvanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrList {
    public static void main(String[] args) {
//        ArrayList<Integer> arrList = new ArrayList<>();

        /*по конвенции привильно писать сслыясь на более высокий инерфейс*/
        List<Integer> arrList = new ArrayList<>();
        //так же из арэйлиста очень затратно чтото менять внутри с начала или с середины
        for (int i = 0; i < 10; i++) {
            arrList.add(i);
        }
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }

        for (Integer x : arrList) {
            System.out.println(x);
        }

        arrList = new LinkedList<>(); //создаем, переносим, делаем какието там изменения более быстрые чем у арр листа]

    }
}
