package jdmarathon.tkhorik;


public class TaskCh03N029 {

    private static final int X = 0;
    private static final int Y = 2;
    private static final int Z = 5;

    public static void main(String[] args) {
        System.out.println("X=0 Y=2 Z=5");
        System.out.println("A проверка: " + A());
        System.out.println("B проверка: " + B());
        System.out.println("C проверка: " + C());
        System.out.println("D проверка: " + D());
        System.out.println("E проверка: " + E());
        System.out.println("F проверка: " + F());
    }

    //а) каждое из чисел X и Y нечетное;
    private static boolean A(){
        return X % 2 != 0 && Y % 2 != 0;
    }

    //б) только одно из чисел X и Y меньше 20;
    private static boolean B(){
        return X < 20 || Y < 20;
    }

    //в) хотя бы одно из чисел X и Y равно нулю;
    private static boolean C(){
        return X == 0 || Y == 0;
    }

    //г) каждое из чисел X, Y, Z отрицательное;
    private static boolean D(){
        return X < 0 && Z < 0 && Y < 0;
    }

    //д) только одно из чисел X, Y и Z кратно пяти;
    private static boolean E(){
        return X == 5 || Z == 5 || Y == 5;
    }

    //е) хотя бы одно из чисел X, Y, Z больше 100.
    private static boolean F(){
        return X > 100 && Z > 100 && Y > 100;
    }
}