import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    // 같은 집합으로 설정
    static void union(int v, int w) {
        int vParent = find(v);
        int wParent = find(w);

        if(vParent > wParent) parent[vParent] = wParent;
        else if(vParent < wParent) parent[wParent] = vParent;
    }

    // 부모 노드 찾기
    static int find(int v) {
        if(parent[v] == v) return v;
        parent[v] = find(parent[v]);
        return parent[v];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획 속 도시 수
        parent = new int[n+1]; // 부모 노드 정보
        for (int i = 0; i < n + 1; i++) { // 자기 자신을 부모로 초기화
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int flag = Integer.parseInt(st.nextToken());
                if(flag == 1) {
                    union(i, j);
                }
            }
        }

        int[] plan = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < m - 1; i++) {
            if(find(plan[i]) != find(plan[i+1])) { // 부모가 다를 경우 : 도시 연결이 끊긴 것.
                System.out.println("NO");
                return ;
            }
        }

        System.out.println("YES");
    }
}
