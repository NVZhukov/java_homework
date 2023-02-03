package homework.hw4;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        int[][] lab = new int[10][10];
        int[] start = new int[]{1, 2};

        Queue<int[]> queueOfNext = new LinkedList<>();
        queueOfNext.add(start);

        int[] dotStart = queueOfNext.element();
        lab[dotStart[0]][dotStart[1]] = 1;

        while (lab[8][8] == 0) {

            int[] dot = queueOfNext.element();

            if ((dot[0] - 1) >= 0 && lab[dot[0] - 1][dot[1]] == 0) {
                lab[dot[0] - 1][dot[1]] = lab[dot[0]][dot[1]] + 1;
                int[] arr1 = new int[]{dot[0] - 1, dot[1]};
                queueOfNext.add(arr1);
            }

            if ((dot[1] + 1) < 10 && lab[dot[0]][dot[1] + 1] == 0) {
                lab[dot[0]][dot[1] + 1] = lab[dot[0]][dot[1]] + 1;
                int[] arr2 = new int[]{dot[0], dot[1] + 1};
                queueOfNext.add(arr2);
            }

            if ((dot[0] + 1) < 10 && lab[dot[0] + 1][dot[1]] == 0) {
                lab[dot[0] + 1][dot[1]] = lab[dot[0]][dot[1]] + 1;
                int[] arr3 = new int[]{dot[0] + 1, dot[1]};
                queueOfNext.add(arr3);
            }

            if ((dot[1] - 1) >= 0 && lab[dot[0]][dot[1] - 1] == 0) {
                lab[dot[0]][dot[1] - 1] = lab[dot[0]][dot[1]] + 1;
                int[] arr5 = new int[]{dot[0], dot[1] - 1};
                queueOfNext.add(arr5);
            }
            printTab(lab);
            queueOfNext.remove();
        }
        printTab(lab);
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
