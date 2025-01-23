import java.io.*;
import java.util.*;

public class Main {

    /**
     * 1. 5번째 줄의 첫 번째 걸 떼는 경우
     * max(직전 줄의 2번째를 떼는 경우 or 아예 안 떼는 경우)
     *
     * 2. 5번째 줄의 두 번째 걸 떼는 경우
     * max(직전 줄의 1번째를 떼는 경우 or 아예 안 떼는 경우)
     *
     * 3. 맨 마지막 줄을 아예 안 떼는 경우
     * 직전 줄의 1번쨰를 떼는 경우 or 2번째를 떼는 경우 or 아예 안 떼는 경우
     *
     * => DP[3][n]으로 분류 가능!
     *
     * 0 = 첫 번째 떼기
     * 1 = 두 번째 떼기
     * 2 = 아예 안 떼기
     *
     * - 점화식
     * DP[0][n] = max(DP[n-1][1] + arr[n-1][1], DP[n-1][2])
     * DP[1][n] = max(DP[n-1][0] + arr[n-1][0], DP[n-1][2])
     * DP[2][n] = max(DP[n-1][0], DP[n-1][1], DP[n-1][2])
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n];
            int[][] dp = new int[3][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[2][0] = 0;

            for (int j = 1; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[2][j-1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[2][j-1]) + arr[1][j];
                dp[2][j] = Math.max(dp[0][j-1], Math.max(dp[1][j-1], dp[2][j-1]));
            }

            System.out.println(Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1])));

        }
    }
}
