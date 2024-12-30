import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], 1000000); // 엄청 큰 값, Integer.MAX_VALUE는 제외;
        }

        for (int i = 1; i <= n; i++) {
            distance[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            distance[a][b] = c;
        }

        // 폴로이드-워셜 알고리즘
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }

        int max = -1;

        for (int i = 1; i <= n; i++) {
            if(x == i) continue;
            max = Math.max(max, distance[x][i] + distance[i][x]);
        }

        System.out.println(max);
    }
}
