package homework.hw6;


public class MapCreator {

    public void printTab(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.printf("%.3s", tab[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public String[][] copy(int[][] src) {
        String[][] newArray = new String[src.length][src[0].length];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                newArray[i][j] = String.format("%3d",src[i][j] );
            }
        }
        return newArray;
    }
}
