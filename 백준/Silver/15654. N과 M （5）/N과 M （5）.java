import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr, combination;
    static boolean[] visited;

    static void solution(int index) {
        if(index == m) {
            for (int i : combination) {
                System.out.print(i + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination[index] = arr[i];
                solution(index + 1);
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
        combination = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution(0);
    }
}
