import java.util.*;
import java.io.*;

public class Main {

    // 연속으로 놓여있는 3잔을 마실 수 없다.
    // P(N) = P(N-1) + 막잔 & P(N-2) + 막잔 & P(n-1)
    // arr(n) + arr(n-1) + C(n-3), arr(n) + C(n-2), C(n-1)
    static int solution(int n, int[] dp, int[] arr) {
        for(int i = 3; i < n; i++) {
            dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], Math.max(arr[i] + dp[i-2], dp[i-1]));
        }

        return dp[n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];
        int[] dp = new int[10001];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(Math.max(arr[0] + arr[2], arr[0] + arr[1]), arr[1] + arr[2]);

        System.out.println(solution(n, dp, arr));
    }
}
