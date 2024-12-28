import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int target, weight;

    public Node(int target, int weight) {
        this.target = target;
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

    static int v,e,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            nodes.add(new ArrayList<>());
        }

        int[] distance = new int[v+1];
        boolean[] visited = new boolean[v+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;
        visited[k] = true;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes.get(u).add(new Node(v,w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k,0));

        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            ArrayList<Node> target = nodes.get(poll.target);
            for (int i = 0; i < target.size(); i++) {
                Node node = target.get(i);
                if(!visited[node.target] && distance[node.target] > node.weight + distance[poll.target]) {
                    distance[node.target] = node.weight + distance[poll.target];
                    pq.add(new Node(node.target, distance[node.target]));
                }
            }
        }

        for (int i=1; i<distance.length; i++) {
            System.out.println(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF");
        }
    }
}
