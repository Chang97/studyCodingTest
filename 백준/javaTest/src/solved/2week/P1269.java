import java.io.*;
import java.util.*;

public class P1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for (int cnt : map.values()) {
            if (cnt == 1) answer++;
        }

        System.out.println(answer);
    }
}
