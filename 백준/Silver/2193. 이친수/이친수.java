import java.io.*;
import java.util.*;

public class Main {

    static long[] dp;

    static long solution(int n) {
        /**
         * N자리 이친수의 개수
         * N=5라고 했을 때, 10xxx = 100xx인 경우 + 101xx인 경우
         * 101xx인 경우 = C(3) // 10100 10101
         * 100xx인 경우 = C(4) // 10000 10001 10010 [1000 1001 1010과 같음.]
         */

        if(n <= 2) return 1;
        else{
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            
            return dp[n];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        System.out.println(solution(n));
    }
}
