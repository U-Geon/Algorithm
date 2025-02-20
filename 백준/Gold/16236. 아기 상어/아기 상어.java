import java.util.*;
import java.io.*;

class Position implements Comparable<Position> {
    int y, x, distance;

    public Position(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }

    @Override
    public int compareTo(Position o) {
        if(this.distance != o.distance) { // 작으면 -1, 크면 1
            return Integer.compare(this.distance, o.distance);
        }
        else if(this.y != o.y) { // 작으면 -1, 크면 1
            return Integer.compare(this.y, o.y);
        }
        else if(this.x != o.x) {
            return Integer.compare(this.x, o.x);
        }

        return 0;
    }

}

public class Main {

    /**
     * size: 아기 상어 사이즈 (초기 2)
     * eat : 먹은 물고기 수
     * move : 움직인 거리
     */
    static int n, size = 2, eat = 0, move = 0;
    static int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int[][] arr;

    static Position bfs(int y, int x) {
        boolean[][] visited = new boolean[n][n];
        Queue<Position> queue = new LinkedList<>();
        List<Position> fishList = new ArrayList<>(); // 같은 거리의 물고기 좌표 모음

        queue.add(new Position(y, x, 0));
        visited[y][x] = true;

        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Position poll = queue.poll();

            // 먹이 발견 및 상어보다 사이즈가 작을 때
            if (arr[poll.y][poll.x] != 0 && arr[poll.y][poll.x] < size) {
                if (poll.distance < minDist) { // 아기 상어보다 사이즈가 작을 때
                    minDist = poll.distance; // 최소 거리
                    fishList.clear();
                }
                if (poll.distance == minDist) {
                    fishList.add(poll);
                }
            }

            for (int[] direction : directions) {
                int ny = poll.y + direction[0];
                int nx = poll.x + direction[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx] > size) continue; // 상어보다 큰 물고기는 못 감

                queue.add(new Position(ny, nx, poll.distance + 1));
                visited[ny][nx] = true;
            }
        }

        // 먹을 수 있는 물고기가 없는 경우
        if (fishList.isEmpty()) return null;

        Collections.sort(fishList);
        return fishList.get(0);
    }

    static int solution(int y, int x) {
        while (true) {
            Position nextFish = bfs(y, x);
            if (nextFish == null) break; // 더 이상 먹을 물고기 없음

            // 물고기 먹기
            arr[nextFish.y][nextFish.x] = 0;
            eat++;
            move += nextFish.distance;
            y = nextFish.y;
            x = nextFish.x;

            // 크기 증가 조건 확인
            if (size == eat) {
                size++;
                eat = 0;
            }
        }
        return move;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        // 아기 상어 위치
        int babyY = 0;
        int babyX = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int pos = Integer.parseInt(st.nextToken());
                arr[i][j] = pos;

                if(pos == 9) {
                    babyY = i;
                    babyX = j;
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(solution(babyY, babyX));
    }
}