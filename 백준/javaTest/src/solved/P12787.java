package solved;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P12787 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            String M = st.nextToken();
            String N = st.nextToken();
            StringBuffer sb = new StringBuffer();
            if (M.equals("1")) {
                String[] arr = N.split("\\.");
                for (String str : arr) {
                    String bNum = String.format("%8s", Integer.toBinaryString(Integer.parseInt(str))).replace(' ', '0');
                    sb.append(bNum);
                }
                BigInteger result = new BigInteger(sb.toString(), 2);
                System.out.println(result);
            } else {
                String binary = new BigInteger(N).toString(2);
                binary = String.format("%64s", binary).replace(' ', '0');
                for (int j = 0; j < binary.length(); j += 8) {
                    String temp = binary.substring(j, j + 8);
                    BigInteger result = new BigInteger(temp, 2);
                    sb.append(result);
                    if (j != 56) sb.append(".");
                }
                System.out.println(sb.toString());
            }
        }


    }
}
