import java.io.*;

public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[1001];
        int answer = 0;

        for (int i = 1; i <= 99; i++) arr[i] = true;

        for (int i = 100; i <= N; i++) {
            char[] cArr = String.valueOf(i).toCharArray();
            char prev = cArr[1];
            int a = cArr[0] - cArr[1];
            boolean isHansu = true;
            for (int j = 2; j < cArr.length; j++) {
                if (a != prev - cArr[j]) {
                    isHansu = false;
                    break;
                }
                a = prev - cArr[j];
            }
            if (isHansu) arr[i] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i]) answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
