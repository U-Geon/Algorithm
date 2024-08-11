import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int gcd(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        while(small > 0) {
            int tmp = small;
            small = big % small;
            big = tmp;
        }
        return big;
    }

    static int result(int a, int b) {
        int gcd = gcd(a, b);
        return (a / gcd) * (b / gcd) * gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);
            System.out.println((a / gcd) * (b / gcd) * gcd + " " + gcd);
        }
    }
}