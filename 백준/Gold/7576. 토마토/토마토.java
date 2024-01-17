import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int count = -1;

    static void solution(int m, int n) {

        Queue<Node> queue = new LinkedList<>();
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) queue.offer(new Node(i, j));
            }
        }

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = poll.x + direction[k][0];
                int ny = poll.y + direction[k][1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[poll.x][poll.y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    static boolean check(int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
            }
        }

        if(check(m, n)) System.out.println(0);
        else {
            solution(m,n);
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0)
                        break;
                    count = Math.max(count, arr[i][j]);
                }
            }
            count--;

            if(!check(m,n)) System.out.println(-1);
            else System.out.println(count);
        }
    }
}