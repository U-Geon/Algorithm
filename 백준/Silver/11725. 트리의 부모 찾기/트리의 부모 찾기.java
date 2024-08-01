import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> arr;
    static int[] parent;
    static boolean[] visited;

    static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        visited[0] = true;
        visited[1] = true;

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            ArrayList<Integer> children = arr.get(poll);
            for(int i = 0; i < children.size(); i++) {
                int child = children.get(i);

                if(!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                    parent[child] = poll;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        parent = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        bfs();

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parent[i]);
        }

    }
}