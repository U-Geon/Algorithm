import java.io.*;
import java.util.*;

public class Main {

    static int solution(int a, int b) {
        Deque<long[]> queue = new ArrayDeque<>();
        queue.add(new long[]{a, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long value = current[0];
            long count = current[1];

            if (value == b) {
                return (int) count;
            }

            if (value * 2 <= b) {
                queue.add(new long[]{value * 2, count + 1});
            }

            if (value * 10 + 1 <= b) {
                queue.add(new long[]{value * 10 + 1, count + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(solution(a, b));
    }
}
