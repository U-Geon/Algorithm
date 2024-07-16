import java.io.*;
import java.math.BigInteger;

public class Main {

    static BigInteger[] memo;

    static BigInteger solution(int n) {
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1].add(memo[i-2]);
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new BigInteger[n + 1];
        memo[0] = BigInteger.valueOf(0);
        if(n >= 1) memo[1] = BigInteger.valueOf(1);

        System.out.println(solution(n));
    }
}