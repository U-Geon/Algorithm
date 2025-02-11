import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int next, weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        if(this.weight != o.weight) {
            return Integer.compare(this.weight, o.weight);
        }
        return 0;
    }

}

public class Main {

    static List<List<Node>> map = new ArrayList<>();

    static int[] dijkstra(Node root) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[map.size()];
        int[] distance = new int[map.size()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[root.next] = 0;

        pq.add(root);

        // 1 -> 2 : 3
        // 1 -> 3 : 5
        // 2 -> 3 : 1
        // 0 0 3 5 - -

        while(!pq.isEmpty()) {
            Node current = pq.poll(); // 2 3

            visited[current.next] = true;

            List<Node> neighbors = map.get(current.next);
            for (int i = 0; i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i); // 3 1
                if(visited[neighbor.next]) continue;

                if(distance[neighbor.next] > neighbor.weight + distance[current.next]) {
                    distance[neighbor.next] = neighbor.weight + distance[current.next];
                    pq.add(new Node(neighbor.next, distance[neighbor.next]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역의 개수
        int m = Integer.parseInt(st.nextToken()); // 예은이 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        for (int i = 0; i < n+1; i++) {
            map.add(new ArrayList<>());
        }

        int[] items = new int[n+1]; // 지역 별 아이템 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map.get(a).add(new Node(b, l));
            map.get(b).add(new Node(a, l));
        }

        int maxItems = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int[] distances = dijkstra(new Node(i, 0));
            int tmp = 0;
            for (int j = 1; j <= n; j++) {
                if(distances[j] <= m) {
                    tmp += items[j];
                }
            }
            maxItems = Math.max(maxItems, tmp);
        }

        System.out.println(maxItems);
    }
}
