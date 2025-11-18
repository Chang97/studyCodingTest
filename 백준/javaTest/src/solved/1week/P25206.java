import java.io.*;
import java.util.*;

public class P25206 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        Map<String, Double> score = new LinkedHashMap<>();
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F" , 0.0);
        
        double totala = 0.0;
        double totalb = 0.0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            double b = Double.parseDouble(st.nextToken());
            String c = st.nextToken();

            if (!c.equals("P")) {
                double _c = score.get(c);
                totala += (b * _c);
                totalb += b;
            }
        }

        bw.write(String.valueOf(totala / totalb));
        bw.flush();
        bw.close();
        br.close();
    }
}
