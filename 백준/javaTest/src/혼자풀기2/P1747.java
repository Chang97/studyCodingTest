package 혼자풀기2;

import java.io.*;

public class P1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;
            for (int j = i * 2; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        for (int i = N; i < arr.length; i++) {
            if (arr[i] != 0) {
                String num = String.valueOf(arr[i]);
                String rNum = new StringBuffer(num).reverse().toString();
                if (num.equals(rNum)) {
                    System.out.println(num);
                    break;
                }
            }
        }

    }
}