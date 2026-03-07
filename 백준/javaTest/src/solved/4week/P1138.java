import java.io.*;
import java.util.*;

public class P1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] left = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for (int i = N; i >= 1; i--) {
            list.add(left[i], i);
        }

        for (int num : list) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());

    }
}
