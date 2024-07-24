import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>(); // LIFO 구조
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            try {
                if(order == 1){
                    int x = Integer.parseInt(st.nextToken());
                    queue.addFirst(x); // deque 앞에 넣기
                } else if(order == 2) {
                    int y = Integer.parseInt(st.nextToken());
                    queue.add(y); // 덱 뒤에 넣기
                } else if(order == 3){
                    Integer poll = queue.poll(); // POP()과 같은 기능 (없으면 null)
                    int value = poll != null ? poll : -1;
                    sb.append(value).append("\n");
                } else if(order == 4){
                    Integer pollLast = queue.pollLast(); // 맨뒤 값 제거 (없으면 Null)
                    int value = pollLast != null ? pollLast : -1;
                    sb.append(value).append("\n");
                } else if(order == 5){
                    sb.append(queue.size()).append("\n");
                } else if(order == 6){
                    int result = queue.isEmpty() ? 1 : 0;
                    sb.append(result).append("\n");
                } else if(order == 7) {
                    sb.append(queue.getFirst()).append("\n"); // peek()와 같음 (없으면 에러)
                } else if(order == 8) {
                    Integer last = queue.getLast(); // 맨 뒤 값 보여주기 (없으면 null)
                    Integer value = last != null ? last : -1;
                    sb.append(value).append("\n");
                }
            } catch (NoSuchElementException e) {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}