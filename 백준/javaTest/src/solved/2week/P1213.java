import java.io.*;

public class P1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alp = new int[26];

        for (char c : str.toCharArray()) {
            alp[c - 'A']++;
        }

        int midIdx = -1;
        boolean isPel = true;

        for (int i = 0; i < alp.length; i++) {
            if (alp[i] % 2 != 0) {
                if (midIdx != -1) {
                    isPel = false;
                    break;
                }
                midIdx = i;
            }
        }
        
        if (isPel) {
            StringBuilder sb = new StringBuilder();
            StringBuilder reverse = new StringBuilder();
            for (int i = 0; i < alp.length; i++) {
                for (int j = 0; j < alp[i] / 2; j++) {
                    sb.append((char) ('A' + i));
                }
            }
            reverse.append(sb.toString());
            reverse.reverse();
            if (midIdx != -1) sb.append((char)('A' + midIdx));
            sb.append(reverse.toString());
            System.out.println(sb.toString());
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}
