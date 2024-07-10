import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static int solution(int n) {
        int[][] dp = new int[n][3];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr.get(0).get(i);
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr.get(i).get(0);
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr.get(i).get(1);
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr.get(i).get(2);
        }

        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arrayList.add(Integer.parseInt(st.nextToken()));
            }
            arr.add(arrayList);
        }

        int result = solution(n);
        System.out.println(result);
    }
}