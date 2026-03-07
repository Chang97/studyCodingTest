import java.io.*;
import java.util.*;

public class P2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 1. 산술평균
        int answer1 = 0;
        for (int i = 0; i < N; i++) {
            answer1 += arr[i];
        }
        sb.append(Math.round((double) answer1 / N)).append("\n");

        // 2. 중앙값
        Arrays.sort(arr);

        int answer2 = arr[N / 2];

        sb.append(answer2).append("\n");

        // 3. 최빈값
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.cnt != b.cnt) return Integer.compare(b.cnt, a.cnt);
            return Integer.compare(a.val, b.val);
        });

        for (int key : map.keySet()) {
            int val = map.get(key);
            pq.add(new Node(key, val));
        }

        Node answer3 = pq.poll();
        if (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (answer3.cnt == temp.cnt) answer3 = temp;
        }
        
        sb.append(answer3.val).append("\n");

        // 4. 범위
        int answer4 = arr[N - 1] - arr[0];
        sb.append(answer4).append("\n");

        bw.write(sb.toString());
        bw.flush();

    }

    static class Node {
        int val;
        int cnt;

        Node (int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
