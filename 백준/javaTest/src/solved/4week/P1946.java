import java.io.*;
import java.util.*;

public class P1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Node[] people = new Node[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int report = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                people[i] = new Node(report, interview);
            }

            Arrays.sort(people, (a, b) -> {
                return Integer.compare(a.report, b.report);
            });

            int min = people[0].interview;
            int answer = 1;
            for (int i = 1; i < N; i++) {
                if (min > people[i].interview) {
                    min = people[i].interview;
                    answer++;
                }
            }

            System.out.println(answer);
        }

    }

    static class Node {
        int report;
        int interview;

        Node (int report, int interview) {
            this.report = report;
            this.interview = interview;
        }
    }
}
