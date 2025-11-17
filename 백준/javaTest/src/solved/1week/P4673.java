import java.io.*;

public class P4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] notSelfNumber = new boolean[10001];

        for (int n = 1; n <= 10000; n++) {
            int _n = n;
            if (notSelfNumber[_n]) continue;
            while(_n <= 10000) {
                char[] arr = String.valueOf(_n).toCharArray();
                for (char c : arr) {
                    _n += c - '0';
                }
                if (_n <= 10000) notSelfNumber[_n] = true;
            }
        }

        for (int i = 1; i < notSelfNumber.length; i++) {
            if (notSelfNumber[i] == false) {
                bw.write(String.valueOf(i + "\n"));
            }
        }

        bw.flush();
        bw.close();
    }
}
