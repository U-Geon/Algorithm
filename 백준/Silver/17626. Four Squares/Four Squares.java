import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;
    static void solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 1; i <= (int) Math.sqrt(poll); i++) {
                int tmp = poll - (int) Math.pow(i,2);
                if(visited[tmp] == 0) {
                    queue.add(tmp);
                    visited[tmp] = visited[poll] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
        visited[n] = 0;

        solution(n);
        System.out.println(visited[0]);
    }
}