package homework.hw6;


import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {

    public int[][] waveAlgorithm(int[][] lab, int x, int y, int fx, int fy) {
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
                        queueOfNext.add(new int[]{dot[0] - 1, dot[1]});
                    }

                    if ((dot[1] + 1) < lab[0].length && lab[dot[0]][dot[1] + 1] == 0) {
                        lab[dot[0]][dot[1] + 1] = lab[dot[0]][dot[1]] + 1;
                        queueOfNext.add(new int[]{dot[0], dot[1] + 1});
                    }

                    if ((dot[0] + 1) < lab.length && lab[dot[0] + 1][dot[1]] == 0) {
                        lab[dot[0] + 1][dot[1]] = lab[dot[0]][dot[1]] + 1;
                        queueOfNext.add(new int[]{dot[0] + 1, dot[1]});
                    }

                    if ((dot[1] - 1) >= 0 && lab[dot[0]][dot[1] - 1] == 0) {
                        lab[dot[0]][dot[1] - 1] = lab[dot[0]][dot[1]] + 1;
                        queueOfNext.add(new int[]{dot[0], dot[1] - 1});
                    }
                    queueOfNext.remove();
                }
            }
        }
        return lab;
    }
}
