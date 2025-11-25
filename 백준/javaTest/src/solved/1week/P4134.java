import java.io.*;
import java.util.*;

public class P4134 {
    static List<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[70001];

        for (int i = 2; i <= 70000; i++) {
            if (!arr[i]) {
                primes.add(i);
                for (int j = i + i; j <= 70000; j += i) {
                    if (arr[j]) continue;
                    arr[j] = true;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            if (n <= 2) {
                System.out.println(2);
            } else {
                if (n % 2 == 0) n++;
                while(!isPrime(n)) {
                    n += 2;
                }
                System.out.println(n);
            }
            
        }
    }

    static boolean isPrime(long x) {
        if (x < 2) return false;
        for (int p : primes) {
            if ((long) p * p > x) break;
            if (x % p == 0) return false;
        }
        return true;

    }

}
