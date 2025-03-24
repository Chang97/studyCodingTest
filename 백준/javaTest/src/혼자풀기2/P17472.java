package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P17472 {
    // 네 방향 탐색을 위한 상수
    static int[] dr = { -1, 0, 1, 0};
    static int[] dc = { 0, 1, 0, -1};
    // 대표노드 저장 배열(유니온파인드)
    static int[] uf;
    // 맵 정보 저장 배열
    static int[][] map;
    // 행렬의 크기
    static int N, M; 
    static int sNum; // 섬 번호
    // BFS 방문여부 저장 배열
    static boolean[][] visited;
    // 모든 섬 정보 저장
    static List<List<int[]>> sumList;
    // 1개의 섬 정보 저장
    static List<int[]> mList;
    // 다리 정보를 저장할 우선순위 큐
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // 입력 데이터 map 변수에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS를 활용하여 섬 정보 저장
        sNum = 1; // 섬 번호
        sumList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 바다가 아니고 방문하지 않은 경우
                if (map[i][j] != 0 && visited[i][j] != true) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(mList);
                }
            }
        }

        // 다리 연결
        // 다리 정보를 저장할 우선순위 큐 (가중치 기준 오름차순 정렬)
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));

        for (int i = 0; i < sumList.size(); i++) { 
            List<int[]> now = sumList.get(i); // 현재 섬에 속한 좌표 리스트

            for (int j = 0; j < now.size(); j++) { 
                int r = now.get(j)[0]; 
                int c = now.get(j)[1];
                int nowS = map[r][c]; // 현재 섬 번호

                // 4방향으로 다리 건설 가능 여부 탐색
                for (int d = 0; d < 4; d++) { 
                    int tempR = dr[d]; 
                    int tempC = dc[d]; 
                    int blength = 0; // 다리 길이 초기화

                    // 경계를 벗어나지 않는 동안 반복
                    while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
                        if (map[r + tempR][c + tempC] == nowS) { // 같은 섬이면 다리 건설 X
                            break;
                        } else if (map[r + tempR][c + tempC] != 0) { // 다른 섬을 만난 경우
                            if (blength > 1) { // 다리 길이가 2 이상이면 유효한 다리로 인정
                                pq.add(new Edge(nowS, map[r + tempR][c + tempC], blength)); // 다리 정보 추가
                            }
                            break; // 다른 섬을 만나면 탐색 종료
                        } else { // 바다를 지나가는 경우
                            blength++; // 다리 길이 증가
                        }

                        // 현재 방향으로 계속 확장 (ex. 위로 이동 중이면 계속 위로)
                        if (tempR < 0) tempR--;
                        else if (tempR > 0) tempR++;
                        else if (tempC < 0) tempC--;
                        else if (tempC > 0) tempC++;
                    }
                }
            }
        }

        // 최소 신장 트리 (MST) 만들기 - 크루스칼 알고리즘
        uf = new int[sNum]; // 유니온-파인드 배열 (각 섬의 대표 노드 저장)
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i; // 초기에는 자기 자신을 대표자로 설정
        }

        int useEdge = 0; // 사용된 다리(엣지) 개수
        int result = 0; // MST 총 비용 (모든 다리의 길이 합)

        // 가중치가 작은 다리부터 연결 (우선순위 큐 사용)
        while (!pq.isEmpty()) {
            Edge now = pq.poll(); // 현재 가장 짧은 다리 꺼내기

            // 두 섬이 아직 같은 집합이 아니라면 (사이클이 아니라면) 다리 연결
            if (find(now.node1) != find(now.node2)) {
                union(now.node1, now.node2); // 두 섬을 하나의 집합으로 합치기
                result += now.value; // 총 다리 길이에 추가
                useEdge++; // 사용한 다리 개수 증가
            }
        }

        // 모든 섬이 연결되었는지 확인 (MST는 V-1개의 엣지를 가져야 함)
        if (useEdge == sNum - 2) { 
            System.out.println(result); // 모든 섬을 연결할 수 있는 경우, 최소 다리 길이 출력
        } else {
            System.out.println(-1); // 모든 섬을 연결할 수 없는 경우 -1 출력
        }


    }

    static void BFS (int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        mList = new ArrayList<>();
        int[] start = { i, j }; // BFS 탐색 시작 위치
        queue.add(start);
        mList.add(start);
        visited[i][j] = true;
        map[i][j] = sNum; // 현재 섬에 고유한 번호 할당
    
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
    
            for (int d = 0; d < 4; d++) { // 4방향 탐색 (상, 우, 하, 좌)
                int tempR = dr[d]; 
                int tempC = dc[d];
    
                // 같은 섬의 다른 부분을 찾기 위한 탐색
                while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
                    // 방문하지 않았고, 바다가 아니라면 (즉, 같은 섬이면)
                    if (!visited[r + tempR][c + tempC] && map[r + tempR][c + tempC] != 0) {
                        map[r + tempR][c + tempC] = sNum; // 현재 섬 번호로 업데이트
                        visited[r + tempR][c + tempC] = true;
                        
                        int[] temp = {r + tempR , c + tempC}; // 새로운 섬 좌표
                        mList.add(temp); // 현재 섬 리스트에 추가
                        queue.add(temp); // BFS 큐에 추가하여 탐색 확장
                    } else {
                        break; // 바다이거나 이미 방문한 경우 종료
                    }
    
                    // 현재 방향으로 계속 확장 (ex. 위로 이동 중이면 계속 위로)
                    if (tempR < 0) tempR--;
                    else if (tempR > 0) tempR++;
                    else if (tempC < 0) tempC--;
                    else if (tempC > 0) tempC++;
                }
            }
        }
    }
    

    static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) uf[b] = a;
    }

    static int find (int a) {
        if (uf[a] == a) return a;
        else return uf[a] = find(uf[a]);
    }

    static class Edge {
        int node1;
        int node2;
        int value;

        public Edge(int node1, int node2, int value) {
            this.node1 = node1;
            this.node2 = node2;
            this.value = value;
        }
    }
}
