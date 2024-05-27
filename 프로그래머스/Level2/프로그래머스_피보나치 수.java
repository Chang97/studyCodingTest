import java.math.*;
class Solution {
    public int solution(int n) {
        BigInteger[] fib = new BigInteger[n + 1];

        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        
        return Integer.parseInt(fib[n].remainder(new BigInteger("1234567")).toString());
    }
}