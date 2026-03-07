import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr1 = str.split("\\-");
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].indexOf('+') != -1) {
                String[] plus = arr1[i].split("\\+");
                int sum = 0;
                for (int j = 0; j < plus.length; j++) {
                    sum += Integer.parseInt(plus[j]);
                }

                arr1[i] = String.valueOf(sum);
            }
        }

        int answer = Integer.parseInt(arr1[0]);
        for (int i = 1; i < arr1.length; i++) {
            int num = Integer.parseInt(arr1[i]);
            answer -= num;
        }

        System.out.println(answer);

    }
}
