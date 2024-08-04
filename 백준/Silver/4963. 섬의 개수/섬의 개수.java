import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] arr;
    static int[][] directions = {{0, 1} ,{1, 1} ,{1, 0}, {0, -1}, {-1, 0}, {1, -1}, {-1, -1}, {-1, 1}};
    static boolean[][] visited;

    static void solution(int y, int x) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{y, x});
        visited[y][x] = true;

        while(!stack.isEmpty()) {
            int[] curr = stack.pop();
            int dy = curr[0];
            int dx = curr[1];

            for (int[] direction : directions) {
                int ny = dy + direction[0];
                int nx = dx + direction[1];

                if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(!visited[ny][nx] && arr[ny][nx] == 1) {
                    stack.push(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int count = 0;

            if(w == 0 && h == 0) break;

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && arr[i][j] == 1) {
                        count++;
                        solution(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }
}