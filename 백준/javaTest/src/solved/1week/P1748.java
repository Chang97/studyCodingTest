import java.io.*;

public class P1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int jarisu = 1;
        int start = 1;

        while (start <= N) {
            int end = start * 10 - 1;
            if (end > N) {
                end = N;
            }

            long count = (long) (end - start + 1);
            answer += count * jarisu;

            start *= 10;
            jarisu++;

        }

        System.out.println(answer);
    }
}
