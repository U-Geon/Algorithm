import java.io.*;
import java.util.*;

public class Main {

    static boolean[] dp;

    static boolean solution(int n) {
        dp[1] = true; // 상근
        for (int i = 3; i <= n; i++) {
            dp[i] = !dp[i - 1] && !dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new boolean[n + 1];

        boolean isSK = solution(n);

        if(isSK) System.out.println("SK");
        else System.out.println("CY");
    }
}