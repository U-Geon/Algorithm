import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][][] arr;

    static int solution(int a, int b, int c) {
        if(a == 0 || b == 0 || c == 0) return 1;
        if(arr[a][b][c] > 1) return arr[a][b][c];

        if(a < b && b < c) arr[a][b][c] = solution(a, b, c-1) + solution(a, b-1, c-1) - solution(a, b-1, c);
        else arr[a][b][c] = solution(a-1,b,c) + solution(a-1, b-1, c) + solution(a-1, b, c-1) - solution(a-1, b-1, c-1);

        return arr[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[21][21][21];
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    arr[i][j][k] = 1;
                }
            }
        }

        while(true) {
            String line = br.readLine().strip();
            if(line.equals("-1 -1 -1")) break;

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int result;

            if(a <= 0 || b <=0 || c <= 0) result = 1;
            else if(a > 20 || b > 20 || c > 20) result = solution(20, 20, 20);
            else result = solution(a, b, c);

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, result);
        }

    }
}