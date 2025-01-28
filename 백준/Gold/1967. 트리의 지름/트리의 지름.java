import java.util.*;
import java.io.*;

class Node {
    int next, weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}

public class Main {

    static List<List<Node>> graph = new ArrayList<>();

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

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        int[] first = dfs(1); // 루트 노드에서 가장 먼 거리의 노드 (지름의 한 끝점)
        int[] second = dfs(first[0]); // 해당 점에서 가장 먼 거리의 노드, 거리 (지름의 나머지 끝 점)
        System.out.println(second[1]);
    }
}