package 문제.실버5;

/*
 * 1. DNA문자열의 길이 S와 부분 문자열의 길이 P를 입력 받는다.
 * 2. 임의의 DNA문자열을 입력받는다. (char[]로 변환)
 * 3. A, C, G, T의 각 알파벳 별 포함 되어야 하는 최소 개수를 입력받는다.
 * 4. 0~P-1 까지의 문자를 기준으로 검사
 * 5. P + i ~ S-1 까지의 문자를 검사 (i가 증가할 때마다. (i-P -> 이전 문자열 기준 가장 앞 문자를 제거))
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
  static int[] checkArr;
  static int[] myArr;
  static int checkSecret;
  public static void main (String[] args) throws NumberFormatException, IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 1.
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    int result = 0;
    char[] A = new char[S];
    checkArr = new int[4];
    myArr = new int[4];
    checkSecret = 0;
    // 2.
    A = br.readLine().toCharArray();
  
    // 3.
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
      if (checkArr[i] == 0) {
        checkSecret++;
      }
    }

    for (int i = 0; i < P; i++) {
      Add(A[i]);
    }
    if (checkSecret == 4) {
      result++;
    }

    for (int i = P; i < S; i++) {
      int j = i - P;
      Add(A[i]);
      Remove(A[j]);
      if (checkSecret == 4) {
        result++;
      }
    }

    System.out.println(result);
    br.close();
  }

  // 검사하는 문자 추가 (슬라이드 될 경우 문자열에서 다음 문자 추가)
  private static void Add(char c) {
    switch(c) {
      case 'A' :
        myArr[0]++;
        if (myArr[0] == checkArr[0]) checkSecret++;
        break;
      case 'C' :
      myArr[1]++;
      if (myArr[1] == checkArr[1]) checkSecret++;
      break;
      case 'G' :
      myArr[2]++;
      if (myArr[2] == checkArr[2]) checkSecret++;
      break;
      case 'T' :
      myArr[3]++;
      if (myArr[3] == checkArr[3]) checkSecret++;
      break;
    }
  }
  // 검사하는 문자 제거 (슬라이드 될 경우 기존 문자열에서 가장 앞 문자 제거)
  private static void Remove(char c) {
    switch(c) {
      case 'A' :
        if (myArr[0] == checkArr[0]) checkSecret--;
        myArr[0]--;
        break;
      case 'C' :
        if (myArr[1] == checkArr[1]) checkSecret--;
        myArr[1]--;
        break;
      case 'G' :
        if (myArr[2] == checkArr[2]) checkSecret--;
        myArr[2]--;
        break;
      case 'T' :
        if (myArr[3] == checkArr[3]) checkSecret--;
        myArr[3]--;
        break;
    }
  }
}
