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

    static int n,m,k,x;

    static int[] dijkstra(int x, ArrayList<ArrayList<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] distance = new int[n+1];
        Arrays.fill(distance, 2000000000);

        boolean[] visited = new boolean[n+1];

        distance[x] = 0;

        pq.add(new Node(x, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.next] = true;

            ArrayList<Node> neighbors = graph.get(cur.next);

            for (Node neighbor : neighbors) {
                if(!visited[neighbor.next] && distance[neighbor.next] > distance[cur.next] + neighbor.weight) {
                    distance[neighbor.next] = distance[cur.next] + neighbor.weight;
                    pq.add(new Node(neighbor.next, distance[neighbor.next]));
                }
            }
        }

        return distance;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, 1));
        }

        int[] distance = dijkstra(x, graph);
        boolean flag = false;
        for (int i = 1; i < n+1; i++) {
            if(distance[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if(!flag) System.out.println(-1);
    }
}