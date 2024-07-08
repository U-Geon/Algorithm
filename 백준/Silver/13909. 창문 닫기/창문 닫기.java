import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 4 - 2, 9 - 3, 16 - 4
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            count++;
        }
        System.out.println(count);
    }
}