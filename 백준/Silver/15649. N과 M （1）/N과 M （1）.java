import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int n, m;

    // 1 2
    //   3
    //   4
    static void solve(String str, int index) {
        if(index == m) {
            System.out.println(str);
            return ;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solve(str + (i+1) + " ", index + 1);
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

        visited = new boolean[n];

        solve("", 0);
    }
}
