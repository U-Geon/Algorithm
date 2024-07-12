import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        while(small > 0) {
            int tmp = big;
            big = small;
            small = tmp % small;
        }

        return big;
    }

    static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a * b) / gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            int maxValue = lcm(m, n);
            int result = -1;

            for (int j = targetX; j <= maxValue; j += m) {
                int idx = j % n;
                if(idx == 0) idx = n;
                if(idx == targetY) {
                    result = j;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}