import java.io.*;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int t = 0; t < N; t++) {
            int[] alphabet = new int[26];
            char[] str = br.readLine().toCharArray();
            boolean isChanged = false;
            char bef = 'x';
            
            boolean isGroupWord = true;

            for (int i = 0; i < str.length; i++) {
                char c = str[i];

                if (i > 0) {
                    if (bef != c) isChanged = true;
                    else isChanged = false;
                }
                if (isChanged && alphabet[c - 'a'] > 0) {
                    isGroupWord = false;
                    break;
                }
                alphabet[c - 'a']++;
                bef = c;
            }
            if (isGroupWord) answer++;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
