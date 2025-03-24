package 혼자풀기2;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class P1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long[] arr = new long[(int) Math.sqrt(B) + 1];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }
        
        int result = 0;
        BigDecimal bA = new BigDecimal(A);
        BigDecimal bB = new BigDecimal(B);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                BigDecimal bd = new BigDecimal(arr[i]);        
                int num = 2;
                while (isDown(bd.pow(num), bB)) {
                    if (isUp(bd.pow(num), bA)) {
                        result++;
                    }
                    num++;
                }
                
            }
        }
        System.out.println(result);
    }
    static boolean isUp(BigDecimal base, BigDecimal limit) {
        if (base.compareTo(limit) >= 0) return true;
        return false;
        
    }
    static boolean isDown(BigDecimal base, BigDecimal limit) {
        if (base.compareTo(limit) <= 0) return true;
        return false;
    }
}


