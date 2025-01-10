import java.io.*;
import java.util.*;

public class Main {

    static int[] permutation;
    static boolean[] visited;

    static void solution(int n, int m, int index) {

        if(index == m) {
            for (int i : permutation) {
                System.out.print(i + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = 0; i < n; i++) {
            // 만약 해당 노드를 방문하지 않았다면?
            if (!visited[i]) {
                visited[i] = true;
                permutation[index] = i + 1;
                solution(n, m, index + 1);

                // 자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation = new int[m];
        visited = new boolean[n];

        solution(n, m, 0);
    }
}
