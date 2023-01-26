package homework.hw2;

import java.io.*;
import java.text.DecimalFormat;

/*Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000
* */

public class Main {
    public static void main(String[] args) {
        String result  = numberPow(getArr());
        writeResult(result);
    }

    public static int[] getArr() {
        int[] a = new int[2];
        try {
            File file = new File("C:\\Users\\Doc\\IdeaProjects\\java_program\\src\\homework\\hw2\\input.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^0-9?!\\.\\-]", "");
                if (line != "") {
                    a[i] = Integer.parseInt(line);
                    i++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static String numberPow(int[] arr) {
        String res = "";
        double d = Math.pow(arr[1], arr[0]);
        DecimalFormat nf = new DecimalFormat("#.######");
        if (arr[0] == 0 && arr[1] == 0) {
            res = String.format("a = %d, b = %d, ответ: Не определено", arr[1], arr[0]);;
        } else {
            res = String.format("a = %d, b = %d, ответ: " + nf.format(d), arr[1], arr[0]);
        }
        return res;
    }

    public static void writeResult(String s) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Doc\\IdeaProjects\\java_program\\src\\homework\\hw2\\output.txt");

            fw.write(s);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
