import java.io.*;
import java.util.*;

public class P25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int answer = 0;
        for (int t = 0; t < N; t++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                set.clear();
            } else {
                if (!set.contains(input)) {
                    set.add(input);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
