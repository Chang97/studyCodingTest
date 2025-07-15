package solved;

import java.io.*;

public class P31867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] K = br.readLine().toCharArray();
        int a = 0; // 홀
        int b = 0; // 짝
        for (char c : K) {
            int num = c - '0';

            if (num % 2 == 1) a++;
            else b++;
        }

        if (a > b) System.out.println(1);
        else if (a < b) System.out.println(0);
        else System.out.println(-1);

    }
}
