import java.io.*;
import java.util.*;

public class P1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1 || M == 1) { // 이동불가
            System.out.println(1);
        } else if (N == 2) { // 2,3 케이스만 사용 가능
            System.out.println(Math.min(4, (M + 1) / 2));
        } else if (N >= 3) { // 모든 케이스 사용가능
            if (M <= 3) {
                System.out.println(M);
            } else if (4 <= M && M <= 6) {
                System.out.println(4);
            } else if (M >= 7) {
                System.out.println(M - 2);
            }
        }

    }

}
