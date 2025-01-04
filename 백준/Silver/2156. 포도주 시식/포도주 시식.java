import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] dp;

    static int solution(int n) {
        // C(1) = 6
        // C(2) = 16
        // C(3) = 6 + 10 or 6 + 13 or 10 + 13
        // C(N) = max(arr(n) + arr(n-1) + C(n-3), arr(n) + C(n-2), C(n-1))

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]), dp[i-1]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[10001];
        dp = new int[10001];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n));
    }
}