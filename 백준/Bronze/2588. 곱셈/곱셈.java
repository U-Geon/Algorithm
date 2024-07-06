import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int c = b % 10 * a;
        int d = b / 10 % 10 * a;
        int e = b / 100 * a;

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(c + d * 10 + e * 100);
    }
}