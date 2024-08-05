import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.add(queue.poll());
            }
            if(queue.size() == 1) {
                sb.append(queue.poll()).append(">");
            } else sb.append(queue.poll()).append(", ");
        }

        System.out.println(sb);
    }
}
