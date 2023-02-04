package homework.hw4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = getInfo();

        int[][] lab = new int[data[0]][data[1]];

        int[][] res = waveLogarithm(lab,data[2] - 1,data[3] - 1,data[4] - 1,data[5] - 1);
        printTab(res);
    }

    public static int[] getInfo(){
        int[] info = new int[6];
        try{
            System.out.println("Введите количество строк на карте: ");
            info[0] = sc.nextInt();
            System.out.println("Введите количество столбцов на карте: ");
            info[1] = sc.nextInt();
            System.out.println("Введите координату Х начальной точки: ");
            info[2] = sc.nextInt();
            System.out.println("Введите координату У начальной точки: ");
            info[3] = sc.nextInt();
            System.out.println("Введите координату Х конечной точки: ");
            info[4] = sc.nextInt();
            System.out.println("Введите координату У конечной точки: ");
            info[5] = sc.nextInt();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Введите корректные данные!");
        }
        return info;
    }

    public static int[][] waveLogarithm(int[][] lab, int x, int y, int fx, int fy){
        int[] start = new int[]{x, y};
        Queue<int[]> queueOfNext = new LinkedList<>();
        queueOfNext.add(start);

        int[] dotStart = queueOfNext.element();
        lab[dotStart[0]][dotStart[1]] = 1;

        while (lab[fx][fy] == 0) {

            int[] dot = queueOfNext.element();

            if ((dot[0] - 1) >= 0 && lab[dot[0] - 1][dot[1]] == 0) {
                lab[dot[0] - 1][dot[1]] = lab[dot[0]][dot[1]] + 1;
                int[] arr1 = new int[]{dot[0] - 1, dot[1]};
                queueOfNext.add(arr1);
            }

            if ((dot[1] + 1) < lab.length && lab[dot[0]][dot[1] + 1] == 0) {
                lab[dot[0]][dot[1] + 1] = lab[dot[0]][dot[1]] + 1;
                int[] arr2 = new int[]{dot[0], dot[1] + 1};
                queueOfNext.add(arr2);
            }

            if ((dot[0] + 1) < lab.length && lab[dot[0] + 1][dot[1]] == 0) {
                lab[dot[0] + 1][dot[1]] = lab[dot[0]][dot[1]] + 1;
                int[] arr3 = new int[]{dot[0] + 1, dot[1]};
                queueOfNext.add(arr3);
            }

            if ((dot[1] - 1) >= 0 && lab[dot[0]][dot[1] - 1] == 0) {
                lab[dot[0]][dot[1] - 1] = lab[dot[0]][dot[1]] + 1;
                int[] arr5 = new int[]{dot[0], dot[1] - 1};
                queueOfNext.add(arr5);
            }
            queueOfNext.remove();
        }
        return lab;
    }

    public static void printTab(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.printf("%3d", tab[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
