import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            try {
                if(order.equals("push")){
                    int x = Integer.parseInt(st.nextToken());
                    queue.add(x);
                } else if(order.equals("pop")) {
                    sb.append(queue.pop()).append("\n");
                } else if(order.equals("front")){
                    Integer peek = queue.peek() == null ? -1 : queue.peek();
                    sb.append(peek).append("\n");
                } else if(order.equals("back")){
                    Integer peekLast = queue.peekLast() == null ? -1 : queue.peekLast();
                    sb.append(peekLast).append("\n");
                } else if(order.equals("size")){
                    sb.append(queue.size()).append("\n");
                } else if(order.equals("empty")){
                    int result = queue.isEmpty() ? 1 : 0;
                    sb.append(result).append("\n");
                }
            } catch (NoSuchElementException e) {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}