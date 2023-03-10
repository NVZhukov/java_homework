package homework.hw4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = getInfo();
        int[][] lab = new int[data[0]][data[1]];

        lab[0][2] = -1;
        lab[1][2] = -1;
        lab[4][1] = -1;
        lab[4][2] = -1;
        lab[4][3] = -1;
        lab[4][4] = -1;
        lab[3][8] = -1;
        lab[3][9] = -1;
        lab[5][9] = -1;
        lab[5][10] = -1;
        lab[6][9] = -1;
        lab[6][10] = -1;


        int[][] res = waveAlgorithm(lab, data[2], data[3], data[4], data[5]);
        String[][] path = finishToStart(res, data[4], data[5]);
        printTab(path);
    }

    public static int[] getInfo() throws MyException {
        int[] info = new int[6];
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Введите корректные данные!");
        }
        for (int j : info) {
            if (j < 0 || info[2] >= info[0] || info[4] >= info[0] || info[3] >= info[1] || info[5] >= info[1]) {
                throw new MyException("Введите корректные данные!");
            }
        }
        return info;
    }

    public static String[][] finishToStart(int[][] matr, int fx, int fy) {
        String[][] mapPath = copy(matr);
        mapPath[fx][fy] = String.format("|%d|", matr[fx][fy]);

        int[] finish = new int[]{fx, fy};

        Queue<int[]> queueOfPath = new LinkedList<>();
        queueOfPath.add(finish);

                while (!queueOfPath.isEmpty()) {

                    int[] path = queueOfPath.element();

                    if ((path[0] - 1) >= 0 && (matr[path[0]][path[1]]) - (matr[path[0] - 1][path[1]]) == 1) {
                        mapPath[path[0] - 1][path[1]] = String.format("|%d|", matr[path[0] - 1][path[1]]);
                        int[] arr1 = new int[]{path[0] - 1, path[1]};
                        queueOfPath.add(arr1);
                    }

                    else if ((path[1] + 1) < matr[0].length && (matr[path[0]][path[1]]) - (matr[path[0]][path[1] + 1]) == 1) {
                        mapPath[path[0]][path[1] + 1] = String.format("|%d|", matr[path[0]][path[1] + 1]);
                        int[] arr2 = new int[]{path[0], path[1] + 1};
                        queueOfPath.add(arr2);
                    }

                    else if ((path[0] + 1) < matr.length && (matr[path[0]][path[1]]) - (matr[path[0] + 1][path[1]]) == 1) {
                        mapPath[path[0] + 1][path[1]] = String.format("|%d|", matr[path[0] + 1][path[1]]);
                        int[] arr3 = new int[]{path[0] + 1, path[1]};
                        queueOfPath.add(arr3);
                    }

                    else if ((path[1] - 1) >= 0 && (matr[path[0]][path[1]] - matr[path[0]][path[1] - 1]) == 1) {
                        mapPath[path[0]][path[1] - 1] = String.format("|%d|", matr[path[0]][path[1] - 1]);
                        int[] arr4 = new int[]{path[0], path[1] - 1};
                        queueOfPath.add(arr4);
                    }
                    queueOfPath.remove();
                }
        return mapPath;
    }

    public static int[][] waveAlgorithm(int[][] lab, int x, int y, int fx, int fy) {
        int[] start = new int[]{x, y};
        Queue<int[]> queueOfNext = new LinkedList<>();
        queueOfNext.add(start);

        int[] dotStart = queueOfNext.element();
        lab[dotStart[0]][dotStart[1]] = 1;

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {

                while (lab[fx][fy] == 0 || lab[i][j] == 0) {

                    int[] dot = queueOfNext.element();

                    if ((dot[0] - 1) >= 0 && lab[dot[0] - 1][dot[1]] == 0) {
                        lab[dot[0] - 1][dot[1]] = lab[dot[0]][dot[1]] + 1;
                        int[] arr1 = new int[]{dot[0] - 1, dot[1]};
                        queueOfNext.add(arr1);
                    }

                    if ((dot[1] + 1) < lab[0].length && lab[dot[0]][dot[1] + 1] == 0) {
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
                        int[] arr4 = new int[]{dot[0], dot[1] - 1};
                        queueOfNext.add(arr4);
                    }
                    queueOfNext.remove();
                }
            }
        }
        return lab;
    }

    public static void printTab(String[][] tab) {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.printf("%.3s", tab[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String[][] copy(int[][] src) {
        String[][] newArray = new String[src.length][src[0].length];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                newArray[i][j] = src[i][j] + "  " ;
            }
        }
        return newArray;
    }
}
