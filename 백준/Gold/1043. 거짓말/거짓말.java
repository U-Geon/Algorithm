import java.io.*;
import java.util.*;

public class Main {

    static int[] parents;

    static int find(int v) {
        if(parents[v] == v) return v;
        parents[v] = find(parents[v]);
        return parents[v];
    }

    static void union(int v1, int v2) {
        int u = find(v1);
        int v = find(v2);

        if(u > v) parents[u] = v; // 0 < 2 이면 0이 부모 (지민이 쪽 집합으로)
        else if(u < v) parents[v] = u;
    }

    /**
     * 파티 별 참여하는 사람들마다 진실된 이야기를 아는 사람이 나온다면
     * 그 파티에 참여한 사람들도 진실을 알게되는 것.
     * 진실을 아는 쪽에 참여시켜야 함.
     * -> 분리 집합.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수

        // 진실을 아는 사람들 집합. (누구에게 속했는가)
        // 지민이를 0번이라고 하자.
        parents = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine().strip());

        // 진실을 아는 사람들.
        int truely = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        if(truely != 0) {
            for (int i = 0; i < truely; i++) {
                int person = Integer.parseInt(st.nextToken());
                parents[person] = 0;
            }
        }

        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().strip());
            parties.add(new ArrayList<>());

            // 각 파티 별 참여하는 사람 수
            int num = Integer.parseInt(st.nextToken());

            int before = Integer.parseInt(st.nextToken());
            parties.get(i).add(before);

            for (int j = 0; j < num - 1; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                parties.get(i).add(tmp);
                union(before, tmp);
                before = tmp;
            }
        }

        int count = 0;

        for (ArrayList<Integer> party : parties) {
            boolean flag = false;
            for (Integer number : party) {
                if(find(number) == 0) flag = true;
            }
            if(!flag) count++;
        }

        System.out.println(count);
    }
}