import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int n;

    static void solution(int num) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(num);
        parent[num] = -2;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < n; i++) {
                if(parent[i] == -1) continue;
                if(tmp == parent[i]) {
                    q.push(i);
                    parent[i] = -2;
                }
            }
        }
    }

    static int find() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(parent[i] == -2) continue;

            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if(parent[j] == -2) continue;
                if(parent[j] == i) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        parent = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }

        int deleteNumber = Integer.parseInt(br.readLine());

        solution(deleteNumber);
        System.out.println(find());
    }
}
