import java.io.*;
import java.util.*;

public class P2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (answer < arr[i] * (N - i + 1)) {
                answer = arr[i] * (N - i + 1);
            }
        }

        System.out.println(answer);
        
    }
}
