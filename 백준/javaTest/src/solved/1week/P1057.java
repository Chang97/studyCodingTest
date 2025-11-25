import java.io.*;
import java.util.*;

public class P1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());

        int round = 0;

        while (true) {
            if (jimin == hansu) {
                System.out.println(round);
                break;
            }
            jimin = (jimin + 1) / 2;
            hansu = (hansu + 1) / 2;
            round++;
        }

        
    }
}
