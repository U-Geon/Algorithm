import java.io.*;

public class Main {

    static StringBuilder sb;

    static void recursive(long n) {
        if(n == 1) {
            sb.append("-");
        } else {
            recursive(n / 3);
            for (int i = 0; i < n / 3; i++) {
                sb.append(" ");
            }
            recursive(n / 3);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = br.readLine();
            if(line == null || line.isBlank()) break;

            int n = Integer.parseInt(line);
            long length = (long) Math.pow(3, n);

            sb = new StringBuilder();

            recursive(length);
            System.out.println(sb.toString());
        }

    }
}