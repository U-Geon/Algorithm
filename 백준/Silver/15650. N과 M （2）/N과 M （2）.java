import java.io.*;
import java.util.*;

public class Main {

    static int[] result;
    static boolean[] visited;
    static int n, m;

    /**
     * @param parent 현재 부모 노드
     * @param index 현재 수열 result의 index
     */
    static void solution(int parent, int index) {
        if(index == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = parent; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[index] = i + 1;
                solution(i + 1, index + 1);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        result = new int[m];

        solution(0, 0);

    }
}
