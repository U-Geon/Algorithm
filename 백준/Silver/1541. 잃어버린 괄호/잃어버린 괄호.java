import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        String[] split = st.nextToken().split("-");

        for (int i = 0; i < split.length; i++) {
            int sum = 0;
            String[] tmp = split[i].split("\\+");
            for (String s : tmp) {
                sum += Integer.parseInt(s);
            }
            if(i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}