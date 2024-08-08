import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringTokenizer st;
        int index = sb.length();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("L")) {
                index = index > 0 ? index-1 : index;
            } else if(order.equals("D")) {
                index = index < sb.length() ? index+1 : index;
            } else if(order.equals("B")) {
                if(index == 0) continue;
                sb.deleteCharAt(--index);
            } else {
                String line = st.nextToken();
                sb.insert(index++, line);
            }
        }

        System.out.println(sb);

    }
}
