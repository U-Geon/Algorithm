import java.io.*;
import java.util.*;

class Item {
    int weight, value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    static int[] weight;
    static int[] value;
    static int[][] dp;

    /**
     * @param n 가방에 넣는 물건 개수
     * @param k 가방의 무게
     * @return
     */
    static int solution(int n, int k) {
        // 마지막에 물건을 넣는 경우, 넣지 않는 경우
        // C(n,k) = max(C(n-1, k-weight[k]) + value[k] , C(n-1, k))
        // 무게가 6인 것을 넣는 경우 : 4,7 -> 3,1 or 3,7 [두 경우의 가치 비교]

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(weight[i] > j) { // i번째 물건을 더 담을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];
                } else { // i번째 무게를 더 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]] + value[i], dp[i-1][j]);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 배낭 최대 무게

        dp = new int[n+1][k+1]; // DP
        weight = new int[n+1]; // 무게
        value = new int[k+1]; // 가치

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 물건 무게
            int v = Integer.parseInt(st.nextToken()); // 물건 가치

            weight[i] = w;
            value[i] = v;
        }

        System.out.println(solution(n, k));
    }
}