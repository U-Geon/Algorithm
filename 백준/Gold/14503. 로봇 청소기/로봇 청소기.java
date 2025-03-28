import java.util.*;
import java.io.*;

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int solution(int r, int c, int directionIndex) {

        // (y,x) 북 동 남 서 (시계)
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(true) {
            boolean isCleaned = true;

            visited[r][c] = true;

            if(map[r][c] == 0) {
                map[r][c] = -1; // 청소
            }

            for (int[] ints : directions) {
                int ny = r + ints[0];
                int nx = c + ints[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                // 청소 되지 않은 경우
                if (map[ny][nx] == 0) {
                    isCleaned = false;
                    break;
                }
            }

            if (isCleaned) {
                int ny = r - directions[directionIndex][0];
                int nx = c - directions[directionIndex][1];

                if(map[ny][nx] == 1) break;

                r = ny;
                c = nx;

            } else {
                directionIndex = (directionIndex + 7) % 4; // 반시계 회전
                int ny = r + directions[directionIndex][0];
                int nx = c + directions[directionIndex][1];

                if(map[ny][nx] == 0) {
                    r = ny;
                    c = nx;
                }
            }
        }

        int result = 0;

        for (int[] ints : map) {
            for (int anInt : ints) {
                if(anInt == -1) result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // (r,c) : 로봇 청소기 좌표
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 청소기가 바라보는 방향 (0~3 : 북, 동, 남, 서)
        
        // 좌표 (r,c) (북서쪽 0,0 / 남동쪽 n-1,m-1)
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(solution(r, c, d));
    }
}
