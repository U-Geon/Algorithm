import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Int implements Comparable<Int> {
        int n;

        public Int(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(Int other) {
            if (Math.abs(other.n) < Math.abs(this.n)) {
                return 1;  // 순서 변경: 작은 절댓값이 먼저 나오도록
            } else if (Math.abs(other.n) > Math.abs(this.n)) {
                return -1;
            } else {
                return Integer.compare(this.n, other.n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Int> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                queue.add(new Int(num));
            } else if(queue.isEmpty()) System.out.println(0);
            else {
                System.out.println(queue.poll().n);
            }
        }
    }
}