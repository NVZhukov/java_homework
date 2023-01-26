package homework.hw1;


import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getNumberByUser("Введите коэффициент для треугольного числа: ");
        int tr = getTriangularNum(n);
        if(tr < 1){
            System.out.println("Введите натуральное число!");
        }else {
            System.out.printf("%d-ое треугольное число = %d",n,tr);
        }
    }


    public static int getNumberByUser(String text) {
        System.out.print(text);
        String s = input.nextLine();
        boolean isNumeric = s.chars().allMatch( Character::isDigit );
        if (!isNumeric){
            return -1;
        }
        return Integer.parseInt(s);
    }

    public static int getTriangularNum(int index) {
        if (index < 1){
            return index;
        }
        if (index == 1) return 1;
        return getTriangularNum(index - 1) + index;
    }
}
