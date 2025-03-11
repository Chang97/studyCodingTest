package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] arr = new boolean[(int) (max - min) + 1];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long s = min / pow;
            if (min % pow != 0) s++;
            for (long j = s; j * pow <= max; j++) {
                arr[(int)((j * pow) - min)] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) result++;
        }
        System.out.println(result);

    }
}
