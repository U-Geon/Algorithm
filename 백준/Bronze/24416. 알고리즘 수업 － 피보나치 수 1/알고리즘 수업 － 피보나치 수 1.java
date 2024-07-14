import java.io.*;
import java.util.*;

public class Main {

    static long[] memo;
    static long recursionCount = 0;
    static long dpCount = 0;

    static long recursion(int n) {
        if(n == 1 || n == 2) {
            recursionCount++;
            return n;
        }
        return recursion(n-1) + recursion(n-2);
    }

    static long dp(int n) {
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
            dpCount++;
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        recursion(n);
        dp(n);

        System.out.println(recursionCount + " " + dpCount);
    }
}