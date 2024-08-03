import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    static void solution(int row, int column, int rain) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, column});
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int[] direct : direction) {
                int ny = y + direct[0];
                int nx = x + direct[1];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(!visited[ny][nx] && arr[ny][nx] > rain) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int maxHeight = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                maxHeight = Math.max(maxHeight, value);
            }
        }

        int maxCount = -1;

        for (int k = 0; k <= maxHeight; k++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j] && arr[i][j] > k) {
                        solution(i, j, k);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}