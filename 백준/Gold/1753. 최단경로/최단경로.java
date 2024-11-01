import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1753 최단경로
class Edge implements Comparable<Edge>{
    int v, w;
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Edge other) {
        if(this.w != other.w) {
            return Integer.compare(this.w, other.w);
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vCount = Integer.parseInt(st.nextToken());
        int eCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startNum = Integer.parseInt(st.nextToken());

        int visited[] = new int[vCount+1];
        int distance[] = new int[vCount+1];
        ArrayList<Edge> edges[] = new ArrayList[vCount + 1];
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        
        for (int i = 1; i < vCount + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = -1;
            edges[i] = new ArrayList<Edge>();
        }

        for (int i=0; i < eCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
        }

        distance[startNum] = 0;
        edgeQueue.add(new Edge(startNum, 0));
        
        while(!edgeQueue.isEmpty()) {
            Edge minNode = edgeQueue.poll();
            visited[minNode.v] = minNode.v;
            for (int i = 0; i < edges[minNode.v].size(); i++) {
                Edge e = edges[minNode.v].get(i);
                if (visited[e.v] != e.v && distance[e.v] > e.w + distance[minNode.v]) {
                    distance[e.v] = e.w + distance[minNode.v];
                    edgeQueue.add(new Edge(e.v, distance[e.v]));
                }
            }
        }

        for (int i=1; i < vCount+1; i++) {
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }

        br.close();
    }
}