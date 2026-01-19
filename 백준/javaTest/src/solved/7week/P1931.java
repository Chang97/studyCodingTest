import java.util.*;
import java.io.*;

public class P1931 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

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
            if (bef.e <= cur.s) {
                answer++;
                bef = cur;
            }
        }

        System.out.println(answer);
    
    
    }

    static class Node {
        int s;
        int e;

        Node (int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
