import java.io.*;
import java.util.*;

public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String wear = st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 1) + 1); // 안입는 경우의수가 있으니 default 1
            }
            int answer = 1;
            
            for (int cnt : map.values()) {
                answer *= cnt;
            }

            answer -= 1; // 전부 안입는 경우의수 제거

            System.out.println(answer);
        }
    }
}
