package homework.hw1;


import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getNumberByUser("Введите коэффициент для треугольного числа: ");
        int tr = getTriangularNum(n);
        System.out.println(tr);
    }


    public static int getNumberByUser(String text) {
        System.out.print(text);
        return input.nextInt();
    }

    public static int getTriangularNum(int index){
        if (index == 1) return 1;
        return getTriangularNum(index - 1) + index;
    }
}
