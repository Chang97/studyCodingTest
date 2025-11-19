import java.io.*;

public class P17478 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String question = "\"재귀함수가 뭔가요?\"\n";
        String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        String answer4 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        String answer5 = "라고 답변하였지.\n";
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        sb.append(question);
        sb.append(answer1);
        sb.append(answer2);
        sb.append(answer3);

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringBuilder indent = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                indent.append("____");
            }
            sb.append(indent.toString());
            sb.append(question);
            if (i < N) {
                sb.append(indent.toString()).append(answer1);
                sb.append(indent.toString()).append(answer2);
                sb.append(indent.toString()).append(answer3);
            } else {
                sb.append(indent.toString()).append(answer4);
            }
        }

        for (int i = N; i >= 1; i--) {
            StringBuilder indent = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                indent.append("____");
            }
            sb.append(indent.toString());
            sb.append(answer5);
        }
        sb.substring(0, sb.length() - 2);
        sb.append(answer5.substring(0, answer5.length() - 1));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
