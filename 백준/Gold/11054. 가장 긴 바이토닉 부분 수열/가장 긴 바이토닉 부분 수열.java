import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] lds = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 알고리즘 (앞에서부터 가장 긴 오름차순 부분 수열)
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS 알고리즘 (뒤에서부터 가장 긴 내림차순 부분 수열)
        for (int i = n-1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            lis[i] += lds[i] - 1;
        }

        System.out.println(Arrays.stream(lis).max().getAsInt());
    }
}