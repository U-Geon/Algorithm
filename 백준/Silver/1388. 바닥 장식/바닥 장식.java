import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static String[] planks;
    static boolean[][] visited;
    static void solution(int row, int col) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] direction : directions) {
                int ny = poll[0] + direction[0];
                int nx = poll[1] + direction[1];

                if(nx < 0 || ny < 0 || ny >= n || nx >= m) continue;
                if(!visited[ny][nx]) {
                    if (planks[poll[0]].charAt(poll[1]) == '|' && planks[ny].charAt(nx) == '|' && direction[1] == 0) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    } else if (planks[poll[0]].charAt(poll[1]) == '-' && planks[ny].charAt(nx) == '-' && direction[0] == 0) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        planks = new String[n];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            planks[i] = br.readLine().strip();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    solution(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}