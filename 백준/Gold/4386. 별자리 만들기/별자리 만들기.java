import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    int start;
    int end;
    double dist;

    public Point(int start, int end, double dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Point other) {
        if(this.dist != other.dist) {
            return Double.compare(this.dist, other.dist);
        }
        return 0;
    }
}

public class Main {
    static int[] parent;
    public static int find(int curr) {
        // find root
        if(parent[curr] == -1) return curr;
        parent[curr] = find(parent[curr]);
        return parent[curr];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        double stars[][] = new double[n+1][2];
        PriorityQueue<Point> edges = new PriorityQueue<>();

        parent = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            parent[i] = -1;
        }
        // index 번호에 별 좌표 넣기.
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i][0] = x;
            stars[i][1] = y;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                double d = Math.sqrt(Math.pow(stars[j][0] - stars[i][0],2) + Math.pow(stars[j][1]-stars[i][1],2));
                edges.add(new Point(i,j,d));
            }
        }

        double cost = 0;

        while(!edges.isEmpty()) {
            Point e = edges.poll();

            int ur = find(e.start);
            int vr = find(e.end);

            if(ur != vr) {
                cost += e.dist;
                parent[vr] = ur;
            }
        }

        String result2 = String.format("%.2f", cost);
        System.out.println(result2);
    }
}
