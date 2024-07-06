import java.io.*;
import java.util.*;


public class Main {

    static int[] solution() {
        int[] arr = new int[1000001];
        Arrays.fill(arr, 0);
        arr[0] = 1; arr[1] = 1;
        for (int i = 2; i < 1000001; i++) {
            for (int j = i * 2; j < 1000001; j += i) {
                arr[j] = 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] primes = solution();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= n / 2; j++) {
                if(primes[j] == 0 && primes[n - j] == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}