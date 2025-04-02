import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int maxValue = 0;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // DFS를 이용한 백트래킹
    static void dfs(int y, int x, int sum, int count) {
        if (count == 4) {
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for (int[] direction : directions) {
            int ny = y + direction[0];
            int nx = x + direction[1];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, sum + map[ny][nx], count + 1);
            visited[ny][nx] = false;
        }
    }

    // 'ㅗ' 모양 체크 (중앙 기준으로 4방향에서 3칸만 선택)
    static void checkExtraShape(int y, int x) {
        int[][] extraShapes = {
                {0, -1, 0, 1, 1, 0},  // ㅜ
                {0, -1, 0, 1, -1, 0}, // ㅗ
                {-1, 0, 1, 0, 0, 1},  // ㅏ
                {-1, 0, 1, 0, 0, -1}  // ㅓ
        };

        for (int[] shape : extraShapes) {
            int sum = map[y][x];  // 중심 좌표
            boolean isValid = true;

            for (int i = 0; i < 3; i++) {
                int ny = y + shape[i * 2];
                int nx = x + shape[i * 2 + 1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    isValid = false;
                    break;
                }

                sum += map[ny][nx];
            }

            if (isValid) {
                maxValue = Math.max(maxValue, sum);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 좌표에서 DFS 탐색 + 'ㅗ' 모양 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;

                checkExtraShape(i, j);  // 'ㅗ' 모양 탐색
            }
        }

        System.out.println(maxValue);
    }
}
