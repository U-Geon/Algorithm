import java.io.*;
import java.util.*;

public class Main {

    static int[] dp, days, prices;

    static int solution(int n) {
        /**
         * 마지막 일을 했을 때, 하지 않았을 때
         *
         * 1. 마지막 일을 했을 때
         * N + day[n]이 N+1보다 작을 때, P(N) = P(N - day[n]) + price[N - day[n]]
         * N + day[n]이 N+1보다 클 때, 이전 결과와 같음 / P(N+1) = P(N)
         * ex> DP[5] = max(DP[4 + days[4]], DP[5] + price[5])
         *
         * 2. 하지 않았을 때
         * 이전 값에 대해 누적이 되어야 함.
         */

        for (int i = 0; i < n; i++) {
            if(i + days[i] <= n) {
                dp[i + days[i]] = Math.max(dp[i + days[i]], dp[i] + prices[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i + 1]); // 누적합
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        days = new int[n+1];
        prices =  new int[n+1];
        dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            days[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n));
    }
}
