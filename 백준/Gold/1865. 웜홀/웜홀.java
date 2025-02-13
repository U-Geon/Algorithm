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

    static int n, m, w;
    static int[] distance;
    static List<List<Node>> road = new ArrayList<>();

    /**
     * 벨만 포드
     * @return 음수 사이클 여부
     */
    static boolean bellmanFord(int start) {
        Arrays.fill(distance, 10001);
        distance[start] = 0;

        boolean isUpdated; // 음수 사이클이 있으면 어떤 노드에서 시작해도 사이클을 감지할 수 있으므로 한 번만 실행해도 됨.

        for (int i = 1; i <= n; i++) { // 모든 노드에 대한 최단거리 계산
            isUpdated = false;

            for (int j = 1; j <= n; j++) { // 모든 엣지에 대해 반복
                for (Node neighbor : road.get(j)) {
                    if(distance[j] != 10001) { // 방문한 노드만 처리
                        if(distance[j] + neighbor.weight < distance[neighbor.next]) { // 거리 가중치 갱신 가능
                            distance[neighbor.next] = distance[j] + neighbor.weight;
                            isUpdated = true;
                        }
                    }
                }
            }

            if(!isUpdated) break; // 갱신이 없으면 조기 종료.
        }

        // 음수 사이클 확인 (n번째 반복 시 값이 갱신되면 음수 사이클 존재)
        for (int j = 1; j <= n; j++) {
            for (Node neighbor : road.get(j)) {
                if (distance[j] != 10001 && distance[neighbor.next] > distance[j] + neighbor.weight) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 지점의 수
            m = Integer.parseInt(st.nextToken()); // 도로의 수
            w = Integer.parseInt(st.nextToken()); // 웜홀의 수

            road.clear();
            for (int j = 0; j < n + 1; j++) {
                road.add(new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); // 시작 지점
                int e = Integer.parseInt(st.nextToken()); // 도착 지점
                int t = Integer.parseInt(st.nextToken()); // 소요 시간

                road.get(s).add(new Node(e, t));
                road.get(e).add(new Node(s, t));
            }
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); // 시작 지점
                int e = Integer.parseInt(st.nextToken()); // 도착 지점
                int t = Integer.parseInt(st.nextToken()); // 줄어드는 시간
                road.get(s).add(new Node(e, -t));
            }

            distance = new int[n + 1];

            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                if(bellmanFord(j)) {
                    flag = true;
                    break;
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
