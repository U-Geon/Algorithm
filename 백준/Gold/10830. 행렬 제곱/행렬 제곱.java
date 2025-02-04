import java.util.*;
import java.io.*;

public class Main {
    static int n;

    // 행렬 거듭제곱 (분할 정복 O(log B))
    static int[][] power(int[][] base, long exp) {
        int[][] result = new int[n][n];

        // 단위 행렬 초기화
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) { // 홀수이면 한 번 더 곱해줌
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp /= 2;
        }

        return result;
    }

    // 행렬 곱셈 (O(N³))
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = power(arr, b);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}