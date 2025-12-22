import java.io.*;

public class P1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        boolean[] passed = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            if (passed[i]) continue;
            for (int k = 0; k < N; k++) {
                if (k == i) continue;
                if (passed[k]) continue;
                if (arr[k].indexOf(arr[i]) == 0) {
                    passed[i] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (!passed[i]) answer++;
        }

        System.out.println(answer);
    }
}
