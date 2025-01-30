import java.util.*;
import java.io.*;

public class Main {

    static int r, c, maxDepth;
    static int[][] board, directions;
    static boolean[] usedLetter; // 사용한 알파벳

    static void dfs(int y, int x, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        for (int[] direction : directions) {
            int ny = y + direction[0];
            int nx = x + direction[1];

            if (ny < 1 || ny > r || nx < 1 || nx > c) continue;

            int alphabet = board[ny][nx] - 65;
            if(usedLetter[alphabet]) continue;

            usedLetter[alphabet] = true;
            dfs(ny, nx, depth + 1);
            usedLetter[alphabet] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        usedLetter = new boolean[26]; // A = 65

        board = new int[r+1][c+1];
        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 1; i <= r; i++) {
            String line = br.readLine().strip();
            for (int j = 1; j <= c; j++) {
                board[i][j] = line.charAt(j-1);
            }
        }

        maxDepth = 0;
        usedLetter[board[1][1] - 65] = true;
        dfs(1, 1, 1);

        System.out.println(maxDepth);
    }
}