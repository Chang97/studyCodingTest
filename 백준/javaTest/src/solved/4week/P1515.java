import java.io.*;
import java.util.*;

public class P1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] nums = br.readLine().toCharArray();

        int cur = 0;
        int pos = 0;
        while (nums.length > pos) {
            String num = String.valueOf(++cur);
            char[] temp = num.toCharArray();
            for (char c : temp) {
                if (pos == nums.length) break;
                if (c == nums[pos]) pos++;
            }
        }

        System.out.println(cur);

    }
}
