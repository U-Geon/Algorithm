import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    static int[] cards;

    static int solution(int n) {
        /**
         * N개 포함 카드팩 - Pn원
         * 돈을 최대한 많이 지불하여 카드 N개 구매.
         * 1개 - 1원 / 2개 5원 / 3개 6원 / 4개 7원
         * 가격 : C(N) = max(C(N-1) + cards[1], C(N-2) + cards[2], C(N-3) + 6, C(N-4) + 7)
         * C(2) = max(1 + 1, 2)
         * C(3) = max(1 + 1 + 1, 2+1, cards[3])
         */
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cards = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = cards[1];

        System.out.println(solution(n));
    }
}
