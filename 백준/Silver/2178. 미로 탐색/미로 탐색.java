import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static int[][] visited;
    static int[][] direction = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    static void solution(int n, int m) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0));
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            Node pop = queue.poll();

            if(pop.x == n && pop.y == m) return ;

            for (int i = 0; i < 4; i++) {
                int nx = pop.x + direction[i][0];
                int ny = pop.y + direction[i][1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = visited[pop.x][pop.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                int i1 = Integer.parseInt(String.valueOf(s.charAt(j)));
                arr[i][j] = i1;
            }
        }

        solution(n,m);

        System.out.println(visited[n-1][m-1]);
    }
}