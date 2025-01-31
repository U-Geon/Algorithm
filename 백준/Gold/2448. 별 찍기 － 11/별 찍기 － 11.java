import java.util.*;
import java.io.*;

public class Main {

    static char[][] arr;

    static void solution(int n, int row, int column) {
        if(n == 3) {
            arr[row][column] = '*';
            arr[row + 1][column - 1] = '*';
            arr[row + 1][column + 1] = '*';
            arr[row + 2][column - 2] = '*';
            arr[row + 2][column - 1] = '*';
            arr[row + 2][column] = '*';
            arr[row + 2][column + 1] = '*';
            arr[row + 2][column + 2] = '*';
            return;
        }

        solution(n/2, row, column);
        solution(n/2, row + n/2, column - n/2);
        solution(n/2, row + n/2, column + n/2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n * 2 - 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        solution(n, 0, n-1);

        for (char[] chars : arr) {
            System.out.println(chars);
        }
    }
}