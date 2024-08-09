import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int j = 0; j < line.length(); j++) {
                char value = line.charAt(j);
                if(value == '<'){
                    index = index > 0 ? index - 1 : index;
                } else if(value == '>'){
                    index = index < sb.length() ? index + 1 : index;
                } else if(value == '-'){
                    if(index > 0) sb.deleteCharAt(--index);
                } else {
                    sb.insert(index, value);
                    index++;
                }
            }
            System.out.println(sb);
        }
    }
}
