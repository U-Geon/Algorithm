import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;

    static int solution(int n) {
        for (int i = 1; i < n; i++) {
            arr[i][0] += arr[i - 1][0];
            for (int j = 1; j < i; j++) {
                arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
            }
            arr[i][i] += arr[i - 1][i-1];
        }

        int max = arr[n-1][0];
        for (int i = 1; i < n; i++) {
            if (arr[n-1][i] > max) {
                max = arr[n-1][i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        arr[0][0] = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solution(n));
    }
}
