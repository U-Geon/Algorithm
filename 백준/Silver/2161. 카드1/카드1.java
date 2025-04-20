import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while(!deque.isEmpty()) {
            Integer poll = deque.pollFirst();
            sb.append(poll).append(" ");
            if(deque.isEmpty()) break;

            deque.offer(deque.pollFirst());
        }

        System.out.println(sb);
    }
}
