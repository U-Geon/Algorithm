import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        if(a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        while(a != 0) {
            int tmp = b % a;
            b = a;
            a = tmp;
        }

        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int gcd = gcd(b, d);

        int denominator = (b / gcd) * (d / gcd) * gcd;
        int numerator = a * (denominator / b) + c * (denominator / d);

        int sumFraction = gcd(denominator,numerator);

        System.out.print(numerator / sumFraction);
        System.out.println(" " + denominator / sumFraction);
    }
}