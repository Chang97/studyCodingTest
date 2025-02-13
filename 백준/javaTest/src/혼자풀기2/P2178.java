package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P2178 {
  /*
    문제
    N×M크기의 배열로 표현되는 미로가 있다.

    1	0	1	1	1	1
    1	0	1	0	1	0
    1	0	1	0	1	1
    1	1	1	0	1	1
    미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

    위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

    입력
    첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

    출력
    첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
   */
  /*
   * 풀이
   * 최단거리를 찾는 문제
   * 가중치가 없기 때문에 BFS를 사용하여 풀이
   * 일반적인 BFS와 동일하게 탐색하되 이동 거리를 세는 배열을 만들어서 진행
   * 큐에 add가 발생할때마다 distance 업데이트 -> 정해진 시작점에서 종료지점까지 거리 구할 수 있음
   */
  static int[][] square;
  static boolean[][] visited;
  static int[][] distance;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    square = new int[N + 1][M + 1];
    distance = new int[N + 1][M + 1];
    visited = new boolean[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++) {
        square[i][j] = str.charAt(j - 1) - '0';
      }
    }

    Queue<Location> queue = new LinkedList<>();

    queue.add(new Location(1, 1));
    distance[1][1] = 1;
    visited[1][1] = true;

    while (!queue.isEmpty()) {
      Location location = queue.poll();
      int y = location.n;
      int x = location.m;
      
      if (location.n == N && location.m == M) {
        System.out.println(distance[y][x]);
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 1 || ny < 1 || nx > M || ny > N) continue;
        if (visited[ny][nx] || square[ny][nx] == 0) continue;
        queue.add(new Location(ny, nx));
        visited[ny][nx] = true;
        distance[ny][nx] = distance[y][x] + 1;
      }
      
    }

  }

  static class Location {
    int n;
    int m;

    Location (int n, int m) {
      this.n = n;
      this.m = m;
    }
  }
}
