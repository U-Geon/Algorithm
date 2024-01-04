import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        long[] arr = new long[101];
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        for (int j = 4; j < 101; j++) {
            arr[j] = arr[j-2] + arr[j-3];
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(arr[n]);
        }
    }
}