import java.io.*;
import java.util.*;


public class Main {

    static class Depth {
        int value, depth;
        public Depth(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    static int bfs(int num, int n) {
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        int[] kevin = new int[n + 1];

        Queue<Depth> queue = new LinkedList<>();
        queue.add(new Depth(num, 0));
        visited[num] = true;

        while(!queue.isEmpty()) {
            Depth poll = queue.poll();

            ArrayList<Integer> friends = arr.get(poll.value);

            for (int i : friends) {
                if (!visited[i]) {
                   count += poll.depth + 1;
                   queue.add(new Depth(i, poll.depth + 1));
                   visited[i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!arr.get(a).contains(b)) arr.get(a).add(b);
            if(!arr.get(b).contains(a)) arr.get(b).add(a);
        }

        int minValue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            int result = bfs(i, n);
            if(result < minValue) {
                minValue = result;
                index = i;
            }
        }

        System.out.println(index);
    }
}