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
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {

    static List<List<Node>> graph = new ArrayList<>();

    // 트리의 최대 지름 -> 임의의 한 점에서 가장 먼점을 구함.
    // 그 점을 기준으로 가장 먼 점을 구함 (트리의 지름)
    // dfs
    static int[] dfs(int start) { // start에서 가장 먼 거리에 있는 노드, 거리 반환
        Stack<Node> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];

        stack.push(new Node(start, 0));

        int maxDistance = 0;
        int maxNode = start;

        visited[start] = true;

        while(!stack.isEmpty()) {
            Node tmp = stack.pop();

            int next = tmp.next;
            int weight = tmp.weight;

            if(weight > maxDistance) {
                maxDistance = weight;
                maxNode = next;
            }

            for (Node node : graph.get(next)) {
                if(!visited[node.next]) {
                    visited[node.next] = true;
                    stack.push(new Node(node.next, weight + node.weight));
                }
            }
        }

        return new int[]{maxNode, maxDistance};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());

        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int vNum = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                graph.get(vNum).add(new Node(num, weight));
            }
        }

        int[] first = dfs(1);
        int[] second = dfs(first[0]);

        System.out.println(second[1]);
    }
}