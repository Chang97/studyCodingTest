import java.io.*;
import java.util.*;

public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e));
        }

        Collections.sort(list, (a, b) -> {
            if (a.e != b.e) return Integer.compare(a.e, b.e);
            return Integer.compare(a.s, b.s);
        });
        
        int answer = 1;
        Node bef = list.get(0);
        for (int i = 1; i < N; i++) {
            Node cur = list.get(i);
            if (cur.s >= bef.e) {
                bef = cur;
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int s;
        int e;

        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
