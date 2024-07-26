import java.io.*;
import java.util.*;

public class Main {

    static long solution(long a, long b, long c) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1)
                result = (result * a) % c;
            a = ((a % c) * (a % c)) % c;
            b /= 2;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(solution(a,b,c));
    }
}