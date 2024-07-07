import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        n = n / 100 * 100;

        int minValue = 0;
        for (int i = 0; i < 100; i++) {
            int tmp = n + i;
            if(tmp % f == 0) {
                minValue = tmp;
                break;
            }
        }

        int result = minValue % 100;
        if(result < 10) System.out.println("0" + result);
        else if(result == f) System.out.println("00");
        else System.out.println(result);
    }
}