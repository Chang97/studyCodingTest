package 혼자풀기;

import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class P1377 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Data[] arr = new Data[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = new Data(i, Integer.parseInt(br.readLine()));
        }
        
        Arrays.sort(arr);
        int Max = 0;
        
        for (int i = 0; i < N; i++) {
            if (Max < arr[i].index - i) Max = arr[i].index - i;
        }
        System.out.println(Max + 1);
        br.close();
    }
    
}

class Data implements Comparable<Data> {
    int index;
    int value;
    
    public Data (int index, int value) {
        this.index = index;
        this.value = value;
    }
    
    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}
