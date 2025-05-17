import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int q = Integer.parseInt(br.readLine());

        // 알파벳 26개에 대해 각각 접두합 배열을 만듦
        int[][] prefix = new int[26][line.length()];

        // 각 알파벳별 접두합 계산
        for (int c = 0; c < 26; c++) {
            char ch = (char) ('a' + c);
            prefix[c][0] = (line.charAt(0) == ch) ? 1 : 0;
            for (int i = 1; i < line.length(); i++) {
                prefix[c][i] = prefix[c][i - 1] + ((line.charAt(i) == ch) ? 1 : 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int idx = a - 'a';
            int count = (l == 0) ? prefix[idx][r] : prefix[idx][r] - prefix[idx][l - 1];
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
