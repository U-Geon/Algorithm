import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int[] arr;

    static void solution(int index, int n, int m) throws IOException {
        if(m == index) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine(); // 줄 바꿈
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(index > 0 && arr[index - 1] > i) continue;
            arr[index] = i;
            solution(index + 1, n, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        solution(0, n, m);

        bw.flush(); // 출력 버퍼를 비워 실제로 출력
        bw.close(); // BufferedWriter를 닫아 자원을 해제
    }
}
