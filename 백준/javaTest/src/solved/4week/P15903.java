import java.io.*;
import java.util.*;

public class P15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] cards = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            Arrays.sort(cards);
            long sum = cards[0] + cards[1];
            cards[0] = sum;
            cards[1] = sum;
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += cards[i];
        }

        System.out.println(answer);
    }
}
