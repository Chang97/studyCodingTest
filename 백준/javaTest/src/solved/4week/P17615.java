import java.io.*;
import java.util.*;

public class P17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        
        int moveRLeft = countMove(arr, 'R', true);
        int moveRRight = countMove(arr, 'R', false);
        int moveBLeft = countMove(arr, 'B', true);
        int moveBRight = countMove(arr, 'B', false);

        int answer = Math.min(moveRLeft, Math.min(moveRRight, Math.min(moveBLeft, moveBRight)));
        System.out.println(answer);
    }

    static int countMove(char[] arr, char color, boolean toLeft) {
        int N = arr.length;
        int count = 0;

        if (toLeft) {
            boolean seenOther = false;
            for (int i = 0; i < N; i++) {
                if (arr[i] != color) {
                    seenOther = true;
                } else if (seenOther) {
                    count++;
                }
            }
        } else {
            boolean seenOther = false;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] != color) {
                    seenOther = true;
                } else if (seenOther) {
                    count++;
                }
            }
        }

        return count;
    }
}
