import java.io.*;
import java.math.BigInteger;

public class Main {

    static BigInteger[] dp;

    static BigInteger solution(int n) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]).add(dp[i-2]);
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = br.readLine();
            if(line == null) break;

            int n = Integer.parseInt(line);

            dp = new BigInteger[n + 1];
            dp[0] = new BigInteger("1");
            if(n >= 1) dp[1] = new BigInteger("1");

            System.out.println(solution(n));
        }
    }
}