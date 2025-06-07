import java.io.*;
import java.util.*;

public class Main {

    static int[][][] dp;

    static int solve(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        else if(a > 20 || b > 20 || c > 20) return solve(20,20,20);
        if(dp[a][b][c] != 0) return dp[a][b][c];

        if(a < b && b < c) {
            dp[a][b][c] = solve(a, b, c-1) + solve(a, b-1, c-1) - solve(a, b-1, c);
        } else {
            dp[a][b][c] = solve(a-1, b, c) + solve(a-1, b-1, c) + solve(a-1,b,c-1) - solve(a-1,b-1,c-1);
        }
        return dp[a][b][c];
    }

    static String wrapper(int a, int b, int c, int result) {
        return "w(" + a + ", " + b + ", " + c + ") = " + result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new int[21][21][21];

        while(true) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break;

            System.out.println(wrapper(a,b,c,solve(a,b,c)));

        }

    }
}
