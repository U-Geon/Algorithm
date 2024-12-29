import java.io.*;
import java.util.*;

class Node {
    int next, weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}

public class Main {

    static int solution(int n, int k) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new Node(n, 0));

        while(!queue.isEmpty()) {
            Node poll = queue.poll();

            if(poll.next < 100001 && poll.next >= 0 && !visited[poll.next]) {
                queue.add(new Node(poll.next*2, poll.weight));
                queue.add(new Node(poll.next-1, poll.weight + 1));
                queue.add(new Node(poll.next+1, poll.weight + 1));
                visited[poll.next] = true;
            }

            if(poll.next == k) return poll.weight;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));
    }
}
