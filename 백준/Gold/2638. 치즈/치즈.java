import java.util.*;
import java.io.*;

class Position {
    int y, x;
    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m;
    static List<Position> cheese = new ArrayList<>(); // 치즈
    static int[][] map;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 바깥 공기 탐색 (BFS)
    static void check() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        map[0][0] = 2;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            for (int[] direction : directions) {
                int ny = cur.y + direction[0];
                int nx = cur.x + direction[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == 0) { // 내부 공간이었던 경우 → 바깥으로 변경
                    map[ny][nx] = 2;
                    queue.add(new Position(ny, nx));
                }
            }
        }
    }

    // 치즈 녹이기 및 바깥 영역 확장
    static void setMeltingCheese() {
        List<Position> melting = new ArrayList<>(); // 녹을 치즈 리스트
        for (Position position : cheese) {
            int count = 0;

            for (int[] direction : directions) {
                int ny = position.y + direction[0];
                int nx = position.x + direction[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == 2) count++; // 바깥 공기와 접촉한 면 개수 카운트
            }

            if (count >= 2) melting.add(position); // 2면 이상 바깥 공기 접촉 → 녹을 치즈
        }

        // 치즈 녹이기
        for (Position pos : melting) {
            map[pos.y][pos.x] = 2; // 바깥 공기로 변경
            cheese.remove(pos);
        }

        // 새롭게 바깥 공기가 된 위치에서 내부 공간을 바깥으로 확장
        expandOutside(melting);
    }

    // 새롭게 생긴 바깥 공간을 확장하는 BFS
    static void expandOutside(List<Position> melting) {
        Queue<Position> queue = new LinkedList<>(melting);

        while (!queue.isEmpty()) {
            Position poll = queue.poll();

            for (int[] direction : directions) {
                int ny = poll.y + direction[0];
                int nx = poll.x + direction[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == 0) { // 내부 공간이었던 경우
                    map[ny][nx] = 2; // 바깥 공기로 변경
                    queue.add(new Position(ny, nx));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if (tmp == 1) cheese.add(new Position(i, j));
            }
        }

        int time = 0;
        check(); // 바깥 공기 초기화

        // 치즈가 다 없어질 때까지 반복
        while (!cheese.isEmpty()) {
            setMeltingCheese();
            time++;
        }

        System.out.println(time);
    }
}
