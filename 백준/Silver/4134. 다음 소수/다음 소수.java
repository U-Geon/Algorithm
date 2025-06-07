import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            if(n == 0 || n == 1) {
                System.out.println(2);
                continue;
            }

            for(long i = n; i <= n * 2; i++) { // 2
                boolean flag = true;
                for(int j = 2; j <= (int) Math.sqrt(i); j++) {
                    if(i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
