import java.io.*;

public class P11723 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        boolean[] S = new boolean[21];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (str.indexOf("add") != -1) {
                int num = Integer.parseInt(str.substring(4));
                S[num] = true;
            } else if (str.indexOf("remove") != -1) {
                int num = Integer.parseInt(str.substring(7));
                S[num] = false;
            } else if (str.indexOf("check") != -1) {
                int num = Integer.parseInt(str.substring(6));
                if (S[num]) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (str.indexOf("toggle") != -1) {
                int num = Integer.parseInt(str.substring(7));
                S[num] = !S[num];
            } else if (str.equals("all")) {
                for (int j = 1; j < 21; j++) S[j] = true;
            } else if (str.equals("empty")) {
                for (int j = 1; j < 21; j++) S[j] = false;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
