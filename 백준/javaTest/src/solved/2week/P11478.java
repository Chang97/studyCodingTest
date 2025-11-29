import java.io.*;
import java.util.*;

public class P11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; i + j <= str.length(); j++) {
                set.add(str.substring(j, i + j));
            }
        }

        System.out.println(set.size());
        
    }
}
