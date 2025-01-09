import java.io.*;
import java.util.Arrays;

public class Main {

    static int[][] dp;

    static int LCS(String a, String b) {
        /**
         * working backward
         * 마지막 단계에서 두 문자를 비교하는 경우
         * ACAYK[] vs CAPCA[]
         * 1. 두 문자가 같은 경우 -> (ACAYK vs CAPCA)에서 가장 긴 수열 + 1
         * 2. 두 문자가 다른 경우 마지막 경우에 영향을 미치지 않음 -> (ACAYK[P] vs CAPCA)와 (ACAYK vs CAPCA[K]) 중 가장 긴 수열의 길이.
         */

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine().strip();
        String b = br.readLine().strip();

        int aSize = a.length();
        int bSize = b.length();
        dp = new int[aSize + 1][bSize + 1];

        System.out.println(LCS(a, b));
    }
}
