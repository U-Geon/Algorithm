import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr = new int[100001];
    static void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 0;

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i : new int[]{poll - 1, poll + 1, poll * 2}) {
                if (i == k) {
                    System.out.println(arr[poll] + 1);
                    return;
                }
                if (i < 0 || i > 100000) continue;
                if (arr[i] != -1) continue;
                arr[i] = arr[poll] + 1;
                queue.add(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, -1);

        if(n - k >= 0) System.out.println(n-k);
        else solution(n, k);
    }
}