import java.util.*;
import java.io.*;

public class Main {
    static long sum = 0L;
    static final int MOD = 1000000007; // MOD 값 고정

    static long solution(int a, int b) {
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;

        long modular = modular(b, MOD - 2);

        return (a * modular) % MOD;
    }

    static int gcd(int x, int y) {
        while (y > 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    static long modular(long b, int exp) {
        long result = 1L;
        while (exp > 0) {
            if (exp % 2 == 1) { // 홀수일 때
                result = (result * b) % MOD;
            }
            b = (b * b) % MOD; // b^2 % MOD
            exp /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            sum = (sum + solution(a, b)) % MOD; // sum을 mod로 유지
        }

        System.out.println(sum);
    }
}
