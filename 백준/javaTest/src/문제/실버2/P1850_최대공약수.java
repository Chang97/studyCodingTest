package 문제.실버2;

import java.util.*;
import java.io.*;
public class P1850_최대공약수 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long tmp = b;
    if (a < b) {
      b = a;
      a = tmp;
    }
    long result = gcd(a, b);
    while (result > 0) {
      bw.write("1");
      result--;
    }
    bw.flush();
    bw.close();
    br.close();
  }

  public static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
