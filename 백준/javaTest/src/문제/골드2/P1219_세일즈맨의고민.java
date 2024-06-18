package 문제.골드2;

import java.io.*;
import java.util.*;

public class P1219_세일즈맨의고민 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, sCity, eCity;
  static long distance[], cityMoney[];
  static Edge edges[];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    sCity = Integer.parseInt(st.nextToken());
    eCity = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    edges = new Edge[M];
    distance = new long[N];
    cityMoney = new long[N];
    Arrays.fill(distance, Long.MIN_VALUE);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int price = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(start, end, price);
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cityMoney[i] = Long.parseLong(st.nextToken());
    }
    distance[sCity] = cityMoney[sCity]; // 변형된 벨만포드 알고리즘 수행

    // 양수 사이클이 전파되도록 충분히 큰 수로 반복
    for (int i = 0; i <= N + 100; i++) {
      for (int j = 0; j < M; j++) {
        int start = edges[j].start;
        int end = edges[j].end;
        int price = edges[j].price;
        // 출발 노드가 방문하지 않은 노드이면 skip
        if (distance[start] == Long.MIN_VALUE) continue;
        // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
        else if (distance[start] == Long.MAX_VALUE) distance[end] = Long.MAX_VALUE;
        // 더 많은 돈을 벌 수 있는 새로운 경로가 발견됐을 때 새로운 경로값으로 업데이트
        else if (distance[end] < distance[start] + cityMoney[end] - price) {
          distance[end] = distance[start] + cityMoney[end] - price;
          // N - 1 반복 이후 업데이트되는 종료 노드는 양수 사이클 연결 노드로 변경
          if (i >= N - 1) distance[end] = Long.MAX_VALUE;
        }
      }
    }
    if (distance[eCity] == Long.MIN_VALUE) System.out.println("gg"); // 도착 불가능
    // 양수 사이클 연결돼 무한대 돈을 벌 수 있을 때
    else if (distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
    else System.out.println(distance[eCity]); // 이외의 경우

    br.close();
  }

  
}

class Edge {
  int start, end, price;

  Edge (int start, int end, int price) {
    this.start = start;
    this.end = end;
    this.price = price;
  }
}
