package homework.hw3;

/*
 * Дана прямоугольная карта размера MxN (N, M меньше 20)
 * На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
 * Посчитать количество маршрутов, по которым фигура может попасть в нижнюю правую клетку
 */


public class Main {

    public static void main(String[] args) {

        printTab(fillMap(8,8,1,2));
    }


    public static int[][] fillMap(int row, int col, int x, int y) {

        int a = x;
        int b = y;
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                while (i < row - x) {
                    map[x][y + j] = 1;
                    x++;
                }
                while (j < col - y) {
                    map[a][y + j] = 1;
                    y++;
                }
            }
        }
        for (int i = a + 1; i < row; i++) {
            for (int j = b + 1; j < col; j++) {
                map[i][j] = (map[i][j - 1] + map[i - 1][j]);
            }
        }
        return map;
    }


    public static void printTab(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.printf("%5d", tab[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
