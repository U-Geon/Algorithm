import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x, y, z;

        public Node(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[][][] arr;

    static int bfs(int h, int n, int m) {
        Queue<Node> q = new LinkedList<>();

        int[][] distance = { {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}, {1,0,0}, {-1,0,0} };

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(arr[i][j][k] == 1) q.offer(new Node(i, j, k));
                }
            }
        }

        int maxValue = -1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int[] ints : distance) {
                int nx = cur.x + ints[2];
                int ny = cur.y + ints[1];
                int nz = cur.z + ints[0];

                if(nx < 0 || nx >= m || ny >= n || ny < 0 || nz < 0 || nz >= h) continue;
                if(arr[nz][ny][nx] == 0) {
                    arr[nz][ny][nx] = arr[cur.z][cur.y][cur.x] + 1;
                    q.offer(new Node(nz, ny, nx));
                }
            }
            maxValue = Math.max(maxValue, arr[cur.z][cur.y][cur.x]);
        }

        return maxValue;
    }

    static boolean check(int h, int n, int m) {
        boolean isAged = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        isAged = false;
                        break;
                    }
                }
                if(!isAged) break;
            }
            if(!isAged) break;
        }
        return isAged;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        if(check(h,n,m)) System.out.println(0);
        else {
            int maxValue = bfs(h, n, m) - 1;

            if(!check(h,n,m)) System.out.println(-1);
            else System.out.println(maxValue);
        }
    }
}