import java.io.*;
import java.util.*;

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int total,n, m; // total : 최소 도시 거리
    static Node[] combination; // 전체 치킨집 중 m개를 고르는 경우
    static boolean[] visited; // 전체 치킨집 중 조합 방문 여부
    static int[][] cities; // 도시 전체
    static ArrayList<Node> houses = new ArrayList<>(); // 가정집 배열
    static ArrayList<Node> chickens = new ArrayList<>(); // 치킨집 배열

    /**
     * @param parent 현재 선택된 치킨집
     * @param index 현재 조합에서 선택된 index
     */
    static void solution(int parent, int index) {
        if(index == m) {
            int totalDistance = 0;
            for (Node house : houses) {
                int distance = Integer.MAX_VALUE;
                for (Node chicken : combination) {
                    distance = Math.min(distance, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
                }
                totalDistance += distance;
            }
            total = Math.min(total, totalDistance);
            return ;
        }
        
        // 전체 치킨집 중 M개의 치킨집을 고르는 조합
        for (int i = parent; i < chickens.size(); i++) {
            if(!visited[i]) {
                visited[i] = true; // 부모 노드 방문

                combination[index] = chickens.get(i); // 조합에 들어가는 경우 선택
                solution(parent + 1, index + 1); // 이후의 경우 선택

                visited[i] = false; // 방문 취소.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 크기
        m = Integer.parseInt(st.nextToken()); // 치킨집 최대 개수
        
        cities = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int coordinate = Integer.parseInt(st.nextToken());
                cities[i][j] = coordinate;
                if(coordinate == 1) houses.add(new Node(i, j));
                if(coordinate == 2) chickens.add(new Node(i, j));
            }
        }

        combination = new Node[m];
        total = Integer.MAX_VALUE;
        visited = new boolean[chickens.size()];

        solution(0, 0);
        System.out.println(total);
    }
}
