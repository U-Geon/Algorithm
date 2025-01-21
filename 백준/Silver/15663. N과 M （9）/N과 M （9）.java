import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    static void solution(int index, String s) {
        if(index == m) {
            set.add(s.trim());
            return;
        }

        // 1 7 9 9
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(index + 1, s + arr[i] + " ");

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution(0, "");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
