package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P2178 {
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
    int count = 0;

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
      count++;
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
