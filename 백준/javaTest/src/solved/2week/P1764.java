import java.io.*;
import java.util.*;

public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> names = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            names.put(br.readLine(), false);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (names.get(str) != null) {
                answer++;
                result.add(str);
            }
        }

        Collections.sort(result);

        sb.append(answer).append("\n");
        result.forEach(name -> sb.append(name).append("\n"));

        bw.write(sb.toString());
        bw.flush();
    }
}
