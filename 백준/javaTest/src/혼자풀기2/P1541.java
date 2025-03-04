package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("\\-");
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].indexOf("+") == -1) {
              temp[i] = Integer.parseInt(arr[i]);
            } else {
                String[] arr2 = arr[i].split("\\+");
            
                int sum = 0;
                for (int j = 0; j < arr2.length; j++) {
                  sum += Integer.parseInt(arr2[j]);
                }
                temp[i] = sum;
            }
        }
        int min = temp[0];
        for (int i = 1; i < temp.length; i++) {
            min -= temp[i];
        }
        System.out.println(min);
        
    }
}
