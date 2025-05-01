import java.util.*;
import java.io.*;

public class Main {

    // dp(1) = 1
    // dp(2) = x, 11
    // dp(3) = 1x, x1, 111
    // dp(4) = x11, xx, 1x1, 11x, 1111
    // dp(5) = 1xx, x1x, xx1
    static int[] dp;
    static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] % 15746 + dp[i-2] % 15746) % 15746;
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        dp = new int[1000001];

        System.out.println(solution(n));
    }
}
