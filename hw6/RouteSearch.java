package homework.hw6;


import java.util.LinkedList;
import java.util.Queue;

public class RouteSearch {

    public String[][] finishToStart(int[][] matr, String[][] mapPath, int fx, int fy) {

        mapPath[fx][fy] = String.format("|%d|", matr[fx][fy]);

        int[] finish = new int[]{fx, fy};

        Queue<int[]> queueOfPath = new LinkedList<>();
        queueOfPath.add(finish);

        while (!queueOfPath.isEmpty()) {

            int[] path = queueOfPath.element();

            if ((path[0] - 1) >= 0 && (matr[path[0]][path[1]]) - (matr[path[0] - 1][path[1]]) == 1) {
                mapPath[path[0] - 1][path[1]] = String.format("|%d|", matr[path[0] - 1][path[1]]);
                queueOfPath.add(new int[]{path[0] - 1, path[1]});
            }

            else if ((path[1] + 1) < matr[0].length && (matr[path[0]][path[1]]) - (matr[path[0]][path[1] + 1]) == 1) {
                mapPath[path[0]][path[1] + 1] = String.format("|%d|", matr[path[0]][path[1] + 1]);
                queueOfPath.add(new int[]{path[0], path[1] + 1});
            }

            else if ((path[0] + 1) < matr.length && (matr[path[0]][path[1]]) - (matr[path[0] + 1][path[1]]) == 1) {
                mapPath[path[0] + 1][path[1]] = String.format("|%d|", matr[path[0] + 1][path[1]]);
                queueOfPath.add(new int[]{path[0] + 1, path[1]});
            }

            else if ((path[1] - 1) >= 0 && (matr[path[0]][path[1]] - matr[path[0]][path[1] - 1]) == 1) {
                mapPath[path[0]][path[1] - 1] = String.format("|%d|", matr[path[0]][path[1] - 1]);
                queueOfPath.add(new int[]{path[0], path[1] - 1});
            }
            queueOfPath.remove();
        }
        return mapPath;
    }
}
