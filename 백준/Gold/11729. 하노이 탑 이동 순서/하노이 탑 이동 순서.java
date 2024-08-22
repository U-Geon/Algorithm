import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int count;

    static void hanoi(int n, int a, int b, int c) {
        if(n > 0) {
            hanoi(n-1, a, c, b);
            sb.append(a).append(" ").append(c).append("\n");
            count++;
            hanoi(n-1, b, a, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        count = 0;

        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1,2,3);
        System.out.println(count);
        System.out.println(sb);
    }
}