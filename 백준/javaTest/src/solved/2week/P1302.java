import java.io.*;
import java.util.*;

public class P1302 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int max = 0;
        List<String> answer = new ArrayList<>();

        for (int cnt  : map.values()) {
            if (max < cnt) max = cnt;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            String name = entry.getKey();
            if (max == cnt) answer.add(name);
        }

        Collections.sort(answer);

        bw.write(answer.get(0));
        bw.flush();
    }
}
