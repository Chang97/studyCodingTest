package 혼자풀기;

import java.util.*;

public class P2018 {
    /*
    1. N 입력 받기
    2. 1 ~ N 까지의 구간합 배열 생성
    3. 시작인덱스s, 종료인덱스e 1부터 시작하여 구간합이 N 보다 작으면 e++, 크면 s++연산 수행하며 N과 같은 케이스 카운트(자기 자신은 제외되기에 answer는 1부터 시작)
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sumArr = new int[N + 1];
        
        int s = 1, e = 1;
        int answer = 1;
        while (e != N) {
            if (sumArr[e] - sumArr[s - 1] < N) {
                e++;
            } else if (sumArr[e] - sumArr[s - 1] > N) {
                s++;
            } else {
                answer++;
                e++;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}