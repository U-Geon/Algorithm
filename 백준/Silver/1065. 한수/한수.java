import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 100) System.out.println(n);
        else {
            int count = 99;
            for (int i = 110; i <= n; i++) {
                String s = String.valueOf(i);
                int diff = s.charAt(1) - s.charAt(0);
                boolean flag = true;
                for (int j = 0; j < s.length() - 1; j++) {
                    int tmp = s.charAt(j+1) - s.charAt(j);
                    if (diff != tmp) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }

            System.out.println(count);
        }
    }
}