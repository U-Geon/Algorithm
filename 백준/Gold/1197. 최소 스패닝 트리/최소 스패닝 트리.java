import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    int u, v, w;
    public Edge(int u, int v, int w) {
        this.u = u;
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
    static int[] parent;
    public static int find(int curr) {
        // find root
        int r = curr;
        while(parent[r] != -1) {
            r = parent[r];
        }

        while(parent[curr] != -1) {
            int reset = parent[curr];
            parent[curr] = r;
            curr = reset;
        }
        return curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        int ans = 0;

        for(int i=0; i<n+1; i++) {
            parent[i] = -1;
        }
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a,b,c));
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>(edgeList);

        while(!edges.isEmpty()) {
            Edge e = edges.poll();

            int ur = find(e.u);
            int vr = find(e.v);

            if(ur != vr) {
                ans += e.w;
                parent[ur] = vr;
            }
        }
        System.out.println(ans);

        br.close();
    }
}