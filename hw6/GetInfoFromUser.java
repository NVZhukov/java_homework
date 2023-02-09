package homework.hw6;

import java.util.Scanner;

public class GetInfoFromUser {

    public static Scanner sc = new Scanner(System.in);

    public int[] getInfo(){
        int[] info = new int[4];
        try {
            System.out.println("Введите координату Х начальной точки: ");
            info[0] = sc.nextInt();
            System.out.println("Введите координату У начальной точки: ");
            info[1] = sc.nextInt();
            System.out.println("Введите координату Х конечной точки: ");
            info[2] = sc.nextInt();
            System.out.println("Введите координату У конечной точки: ");
            info[3] = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Введите корректные данные!");
        }
        return info;
    }
}
