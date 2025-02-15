import java.util.*;
import java.io.*;

class Node {
    int y, x, wall;

    public Node(int y, int x, int wall) {
        this.y = y;
        this.x = x;
        this.wall = wall;
    }
}

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {0, 0, 1, -1}; // 우, 좌, 하, 상
    static int[] dy = {1, -1, 0, 0};

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0)); // 시작점 (y, x, 벽 부순 여부)
        dist[0][0][0] = 1; // 시작 거리

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int wall = cur.wall; // 벽을 부쉈는지 여부 (0: X, 1: O)

            // 도착점 도달 시 거리 반환
            if (y == n - 1 && x == m - 1) return dist[y][x][wall];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                // 벽이 아닐 경우 (이동 가능)
                if (map[ny][nx] == 0 && dist[ny][nx][wall] == 0) {
                    dist[ny][nx][wall] = dist[y][x][wall] + 1;
                    q.add(new Node(ny, nx, wall));
                }

                // 벽이지만 아직 벽을 부수지 않은 경우
                else if (map[ny][nx] == 1 && wall == 0 && dist[ny][nx][1] == 0) {
                    dist[ny][nx][1] = dist[y][x][wall] + 1;
                    q.add(new Node(ny, nx, 1));
                }
            }
        }
        return -1; // 도달 불가능
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m][2]; // 3차원 배열: dist[y][x][벽 부쉈는지 여부]

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
