import java.io.*;
import java.util.*;

public class Main {

    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();

        while (t-- > 0) {
            String p = br.readLine().strip();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();
            deque.clear();

            array = array.substring(1, array.length() - 1);
            StringTokenizer st = new StringTokenizer(array,",");

            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                deque.addLast(tmp);
            }

            boolean isFlip = false;
            boolean isEmpty = false;

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if(c == 'R') isFlip = !isFlip;
                else if(c == 'D') {
                    if(deque.isEmpty()) {
                        isEmpty = true;
                        break;
                    }
                    if(!isFlip) deque.poll();
                    else deque.pollLast();
                }
            }

            if(isEmpty) {
                System.out.println("error");
                continue;
            }

            int size = deque.size();

            if(!isFlip) {
                System.out.print("[");
                for (int i = 0; i < size; i++) {
                    int poll = deque.poll();
                    if(i == 0) System.out.print(poll);
                    else System.out.print("," + poll);
                }
                System.out.println("]");
            } else {
                System.out.print("[");
                for (int i = 0; i < size; i++) {
                    int poll = deque.pollLast();
                    if(i == 0) System.out.print(poll);
                    else System.out.print("," + poll);
                }
                System.out.println("]");
            }
        }
    }
}