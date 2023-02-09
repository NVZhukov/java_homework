package homework.hw6;


public class Main {
    public static void main(String[] args) {
        MapCreator mc = new MapCreator();
        GetInfoFromUser ui = new GetInfoFromUser();
        WaveAlgorithm lee = new WaveAlgorithm();
        RouteSearch rs = new RouteSearch();
        var mg = new MapForWaveAlgorithm();

        int[] info = ui.getInfo();
        int[][] map = mg.getMap();
        int[][] waveAlgorithm = lee.waveAlgorithm(map,info[0],info[1],info[2],info[3]);
        String[][] mapCopy = mc.copy(waveAlgorithm);
        String[][] getRoute = rs.finishToStart(waveAlgorithm,mapCopy,info[2],info[3]);
        mc.printTab(getRoute);
    }
}
