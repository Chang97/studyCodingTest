package 문제.실버2;

import java.util.*;
import java.io.*;
public class P1541_잃어버린괄호 {
  static int answer = 0;
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String example =  st.nextToken();
    String[] str =  example.split("-");
    for (int i = 0; i < str.length; i++) {
      int temp = mySum(str[i]);
      if (i == 0) {
        answer = answer + temp;
      } else {
        answer = answer - temp;
      }
    }
    System.out.println(answer);
    br.close();
  }

  static int mySum(String s) {
    int sum = 0;
    String temp[] = s.split("[+]");
    for (int i = 0; i < temp.length; i++) {
      sum += Integer.parseInt(temp[i]);
    }
    return sum;
  }
}
