import java.io.*;
import java.util.*;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((val1, val2) -> {
            if (map.get(val1) != map.get(val2)) {
                return map.get(val2) - map.get(val1);
            } 
            if (val1.length() != val2.length()) {
                return val2.length() - val1.length();
            }
            return val1.compareTo(val2);
        });
        

        for (int t = 0; t < N; t++) {
            String str = br.readLine();
            if (str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        map.forEach((word, cnt) -> {
            pq.add(word);
        });

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
