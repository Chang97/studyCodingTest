
import java.io.*;

public class P2941 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cAlps = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine();
        int answer = 0;
        while (str.length() > 0) {
            boolean isCalp = false;
            for (String cAlp : cAlps) {
                int startIdx = cAlp.length();
                if (str.length() >= cAlp.length()) {
                    String subStr = str.substring(0, cAlp.length());
                    if (subStr.equals(cAlp)) {
                        str = str.substring(startIdx);
                        answer ++;
                        isCalp = true;
                        break;
                    }
                }
            }
            if (!isCalp) {
                str = str.substring(1);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
