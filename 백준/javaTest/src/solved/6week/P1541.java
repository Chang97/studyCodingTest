import java.io.*;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("\\-");
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.indexOf("+") != -1) {
                String[] nums = str.split("\\+");
                int sum = 0;
                for (String sNum : nums) {
                    int num = Integer.parseInt(sNum);
                    sum += num;
                }
                temp[i] = sum;
            } else {
                temp[i] = Integer.parseInt(str);
            }
        }

        int answer = temp[0];
        for (int i = 1; i < temp.length; i++) {
            answer -= temp[i];
        }

        System.out.println(answer);

    }
}