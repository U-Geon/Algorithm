import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] lines = new String[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine().strip();
            lines[i] = line;
        }

        for (int i = 0; i < lines[0].length(); i++) {
            boolean flag = false;
            for (int j = 0; j < n-1; j++) {
                if (lines[j].charAt(i) != lines[j+1].charAt(i)) {
                    flag = true;
                }
            }
            if(!flag) sb.append(lines[0].charAt(i));
            else sb.append("?");
        }

        System.out.println(sb);
    }
}