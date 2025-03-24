package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1854 {
    static List<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] city = new int[1001][1001];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[n + 1];
        Comparator<Integer> cp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i <= n; i++) {
            distanceQueue[i] = new PriorityQueue<>(k, cp);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            city[a][b] = c;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.w < o2.w ? -1 : 1;
        });
        pq.add(new Node(1, 0));
        distanceQueue[1].add(0);
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            for (int i = 1; i <= n; i++) {
                if (city[u.v][i] != 0) {
                    if (distanceQueue[i].size() < k) {
                        distanceQueue[i].add(u.w + city[u.v][i]);
                        pq.add(new Node(i, u.w + city[u.v][i]));
                    } else if (distanceQueue[i].peek() > u.w + city[u.v][i]) {
                        distanceQueue[i].poll();
                        distanceQueue[i].add(u.w + city[u.v][i]);
                        pq.add(new Node(i, u.w + city[u.v][i]));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distanceQueue[i].size() == k) {
                bw.write(distanceQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int v;
        int w;

        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
