import java.io.*;
import java.util.*;

public class P12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (S.length() < T.length()) {
            String str = T.substring(T.length() - 1, T.length());
            T = new StringBuilder(T.substring(0, T.length() - 1));
            if (str.equals("B")) {
                T = T.reverse();
            }
        }

        if (S.equals(T.toString())) System.out.println(1);
        else System.out.println(0);
        

    }
}
