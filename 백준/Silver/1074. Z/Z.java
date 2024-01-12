import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt = 0;
    static void solution(int n, int r, int c) {
        int size = (int) Math.pow(2, n);

        if(size == 1) return ;

        if(r < size / 2 && c < size / 2) {
            solution(n-1, r, c); // 1사분면
        } else if(r < size / 2 && c >= size / 2) {
            cnt += (size * size) / 4;
            solution(n-1, r, c - size / 2); // 2사분면
        } else if(r >= size / 2 && c < size / 2) {
            cnt += (size * size / 4) * 2;
            solution(n-1, r - size / 2, c); // 3사분면
        } else {
            cnt += (size * size / 4) * 3;
            solution(n-1, r - size / 2, c - size / 2); // 4사분면
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solution(n,r,c);

        System.out.println(cnt);
    }
}