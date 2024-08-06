import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    static int solution(int row, int col) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            for (int[] ints : direction) {
                int ny = y + ints[0];
                int nx = x + ints[1];

                if(ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                if(!visited[ny][nx] && arr[ny][nx] == 0) {
                    count++;
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    arr[j][l] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] == 0) {
                    count++;
                    result.add(solution(i,j));
                }
            }
        }
        System.out.println(count);
        result.sort(Comparator.naturalOrder());
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
