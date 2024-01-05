import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[1001];
    static long result(int n) {
        for (int i = 2; i < n+1; i++) {
            arr[i] = arr[i-1] + arr[i-2] * 2;
            arr[i] %= 10007;
        }
        return arr[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr[0] = 1;
        arr[1] = 1;

        System.out.println(result(n) % 10007);
    }
}