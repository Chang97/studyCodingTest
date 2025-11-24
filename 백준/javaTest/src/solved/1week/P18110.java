import java.io.*;
import java.util.*;

public class P18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] level = new int[N];
        for (int t = 0; t < N; t++) {
            level[t] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);
        int cut = (int) Math.round(N * 0.15);

        int sum = 0;
        for (int i = cut; i < N - cut; i++) {
            sum += level[i];
        }

        int count = N - 2 * cut;
        int answer = (int) Math.round((double) sum / count);
        System.out.println(answer);

    }
}
