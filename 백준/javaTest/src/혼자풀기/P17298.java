package 혼자풀기;

import java.util.*;
import java.io.*;

public class P17298 {
    /**
    1. N을 입력 받는다.
    2. N만큼 수를 입력받는다.
    3. 스택을 이용해서 입력받은 값과 peek를 비교하여 처리
    */
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            } 
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}

