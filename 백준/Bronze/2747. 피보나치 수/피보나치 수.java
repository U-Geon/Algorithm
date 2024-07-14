import java.io.*;
import java.util.*;

public class Main {

    static int[] memo;

    static int fibo(int n) {
        if(n <= 1) return memo[n];
        if(memo[n] > 0) return memo[n];

        memo[n] = fibo(n-1) + fibo(n-2);
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibo(n));
    }
}