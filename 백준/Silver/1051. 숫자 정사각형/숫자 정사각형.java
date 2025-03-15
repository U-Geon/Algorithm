import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int startSize = Math.min(n, m);

        while(startSize > 0) {
            boolean flag = false;

            for(int i = 0; i < n - startSize + 1; i++) {
                for(int j = 0; j < m - startSize + 1; j++) {
                    if(board[i][j] == board[i + startSize - 1][j]
                            && board[i][j] == board[i + startSize - 1][j + startSize - 1]
                            && board[i][j] == board[i][j + startSize - 1]) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) break;
            startSize--;
        }

        System.out.println(startSize * startSize);
    }
}
