import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;

    static void combination(int[] arr, int index, int m) {
        if(m == 0) {
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return ;
        }

        if(index != arr.length) {
            visited[index] = true;
            combination(arr, index+1, m-1);

            visited[index] = false;
            combination(arr,index+1, m);
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        visited = new boolean[n];

        combination(arr,0, m);
    }
}