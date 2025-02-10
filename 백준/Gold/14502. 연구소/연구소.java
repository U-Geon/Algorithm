import java.util.*;
import java.io.*;

class Node {
    int x,y;

    public Node(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, maxValue;
    static int[][] arr;
    static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    static List<Node> virus = new ArrayList<>();

    // 바이러스 퍼트릴 경로
    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        int[][] arr_copy = new int[n][m]; // bfs를 실행할 임시 배열 생성.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr_copy[i][j] = arr[i][j];
            }
        }

        int count = 0; // 0의 개수

        for (Node node : virus) {
            queue.add(node);
        }

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int[] d : direction) {
                int y = cur.y + d[0];
                int x = cur.x + d[1];

                if (y >= 0 && y < n && x >= 0 && x < m) {
                    if(arr_copy[y][x] == 0) {
                        arr_copy[y][x] = 2;
                        queue.add(new Node(y, x));
                    }
                }
            }
        }


        for (int[] ints : arr_copy) {
            for (int anInt : ints) {
                if(anInt == 0) count++;
            }
        }

        maxValue = Math.max(count, maxValue);
    }

    static void backtracking(int count) {
        if(count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1; // 벽 설정.
                    backtracking(count + 1);
                    arr[i][j] = 0; // 벽 x
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

        arr = new int[n][m];
        maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int node = Integer.parseInt(st.nextToken());
                arr[i][j] = node;
                if(node == 2) virus.add(new Node(i, j));
            }
        }

        backtracking(0);
        System.out.println(maxValue);

    }
}
