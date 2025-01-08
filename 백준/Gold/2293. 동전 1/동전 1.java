import java.io.*;
import java.util.*;

public class Main {

    static long[] dp;
    static int[] coins;

    static long solution(int k) {
        /**
         * N가지 동전을 적당히 사용하여 가치의 합이 K원이 되게 함.
         * C(N) = (C(N-5) + 5, C(N-2) + 2, C(N-1) + 1)
         * 중복 제거 필요.
         */

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new long[k+1];
        coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        System.out.println(solution(k));
    }
}
