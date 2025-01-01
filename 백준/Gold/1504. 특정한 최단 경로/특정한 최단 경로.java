import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int next, weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        if(this.weight != other.weight) {
            return Integer.compare(this.weight, other.weight);
        }
        return 0;
    }
}

public class Main {

    static int n, e;
    static ArrayList<ArrayList<Node>> graph;

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] distance = new int[graph.size() + 1];
        boolean[] visited = new boolean[graph.size()+1];
        Arrays.fill(distance, 8000000);

        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node minNode = pq.poll();
            visited[minNode.next] = true;

            ArrayList<Node> neighbors = graph.get(minNode.next);
            for (int i = 0; i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);

                if(!visited[neighbor.next] && distance[neighbor.next] > neighbor.weight + distance[minNode.next]) {
                    distance[neighbor.next] = neighbor.weight + distance[minNode.next];
                    pq.add(new Node(neighbor.next, distance[neighbor.next]));
                }
            }
        }
        return distance;
    }

    static int solution(int v1, int v2) {
        int[] v1Distance = dijkstra(v1);
        int[] v2Distance = dijkstra(v2);

        // v1 = 1 & v2 = n이면서 경로가 끊기지 않은 경우
        if(v1 == 1 && v2 == n && v1Distance[n] < 8000000) return v1Distance[n];
        // 경로가 끊긴 경우
        else if(v1Distance[v2] >= 8000000 || v1Distance[n] >= 8000000 || v2Distance[n] >= 8000000) return -1;

        int v1ToOne = v1Distance[1];
        int v1ToV2 = v1Distance[v2];
        int v1ToN = v1Distance[n];
        int v2ToOne = v2Distance[1];
        int v2ToN = v2Distance[n];

        // 1 -> v1 -> v2 -> N
        int case1 = v1ToOne + v1ToV2 + v2ToN;
        // 1 -> v2 -> v1 -> N
        int case2 = v2ToOne + v1ToV2 + v1ToN;

        return Math.min(case1, case2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine().strip());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine().strip());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(solution(v1, v2));
    }
}
