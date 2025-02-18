import java.util.*;
import java.io.*;

class Bus implements Comparable<Bus> {
    int next, weight;

    public Bus(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bus other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class Main {
    static int n, m;
    static List<List<Bus>> arr = new ArrayList<>();
    static int[] parent;

    // visited 배열 제거
    // 이미 길이가 짧으면 할 필요 없음.
    static int dijkstra(int start, int end) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();
            int now = bus.next;
            int nowDist = bus.weight;

            // 현재 노드까지의 거리가 이미 최단 거리보다 크다면 무시
            if (distance[now] < nowDist) continue;

            for (Bus neighbor : arr.get(now)) {
                int next = neighbor.next;
                int newDist = nowDist + neighbor.weight;

                if (newDist < distance[next]) {
                    distance[next] = newDist;
                    pq.add(new Bus(next, newDist));
                    parent[next] = now; // 최단 거리 갱신 시 부모 업데이트
                }
            }
        }
        return distance[end];
    }

    static List<Integer> findRoute(int end) {
        List<Integer> route = new ArrayList<>();
        while (parent[end] != end) {
            route.add(end);
            end = parent[end];
        }
        route.add(end);
        Collections.reverse(route);
        return route;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Bus(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int minDistance = dijkstra(start, end);
        List<Integer> route = findRoute(end);

        sb.append(minDistance).append("\n");
        sb.append(route.size()).append("\n");
        for (int city : route) {
            sb.append(city).append(" ");
        }

        System.out.println(sb);
    }
}
