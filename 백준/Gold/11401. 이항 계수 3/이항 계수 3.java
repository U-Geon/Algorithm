import java.io.*;
import java.util.*;

public class Main {

    //  nCk = n!/k!(n-k)! = n-1Ck-1 + n-1Ck
    static final long MOD = 1000000007L;

    static long[] factorial;

    // (a^b % mod)
    static long modPow(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b % 2) == 1) {  // b가 홀수인 경우
                result = (result * a) % Main.MOD;
            }
            a = (a * a) % Main.MOD;
            b /= 2;
        }
        return result;
    }

    // 이항계수 구하기
    static long binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        // nCk = n! / (k! * (n-k)!)
        long numerator = factorial[n]; // n!
        long denominator = (factorial[k] * factorial[n - k]) % MOD; // k! * (n-k)!

        // 페르마의 소정리를 이용하여 denominator^(MOD-2) 계산
        return (numerator * modPow(denominator, MOD - 2)) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 팩토리얼 계산 (1! ~ n! 까지)
        factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        // 이항 계수 계산 및 출력
        System.out.println(binomialCoefficient(n, k));
    }
}
