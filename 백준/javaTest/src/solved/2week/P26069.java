import java.io.*;
import java.util.*;

public class P26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> map = new HashMap<>();
        map.put("ChongChong", true);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if (map.get(name1) == null) map.put(name1, false);
            if (map.get(name2) == null) map.put(name2, false);

            if (map.get(name1)) {
                map.put(name2, true);
            }

            if (map.get(name2)) {
                map.put(name1, true);
            }
        }

        int answer = 0;
        for (boolean bool : map.values()) {
            if (bool) answer++;
        }

        System.out.println(answer);
    }
}
