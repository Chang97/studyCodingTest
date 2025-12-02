import java.io.*;
import java.util.*;

public class P11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        long max = 0;

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
            if (cnt > max) {
                max = cnt;
            }
        }

        List<Long> list = new ArrayList<>();
        for (String num : map.keySet()) {
            long cnt = map.get(num);
            if (max == cnt) {
                list.add(Long.parseLong(num));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
