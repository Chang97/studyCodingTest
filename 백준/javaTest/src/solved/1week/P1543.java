import java.io.*;

public class P1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String search = br.readLine();
        int answer = 0;

        while (str.length() >= search.length()) {
            int idx = str.indexOf(search);
            if (idx >= 0) {
                str = str.substring(idx + search.length());
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);

    }
}
