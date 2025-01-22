import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    static void solution(int index, int depth, String s) {
        if(depth == m) {
            set.add(s.trim());
            return;
        }

        for (int i = index; i < n; i++) {
            solution(i, depth + 1, s + arr[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution(0, 0, "");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
