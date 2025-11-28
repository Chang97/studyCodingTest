import java.io.*;
import java.util.*;

public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new LinkedHashMap<>();
        Map<String, Integer> map2 = new LinkedHashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int num = Integer.parseUnsignedInt(input);
                bw.write(map1.get(num));
            } catch (NumberFormatException e) {
                bw.write(String.valueOf(map2.get(input)));
            }
            bw.newLine();
        }

        bw.flush();
    }
    
}