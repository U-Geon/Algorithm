import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        if(a > b) {
            long tmp = b;
            b = a;
            a = tmp;
        }

        while(a != 0) {
            long tmp = b % a;
            b = a;
            a = tmp;
        }

        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        long gcd = gcd(a, b);

        System.out.println( (a / gcd) * (b / gcd) * gcd);
    }
}