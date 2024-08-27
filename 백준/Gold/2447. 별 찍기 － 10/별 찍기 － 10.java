import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;

    static void solution(int n, int row, int column) {
        int next = n / 3;

        if(next < 3) {
            int midRow = (2 * row + 3) / 2;
            int midColumn = (2 * column + 3) / 2;

            for (int i = row; i < row + 3; i++) {
                for (int j = column; j < column + 3; j++) {
                    if(i != midRow || j != midColumn) arr[i][j] = "*";
                }
            }
        } else {
            solution(next, row, column);
            solution(next, row, column + next);
            solution(next, row, column + next * 2);
            solution(next, row + next, column);

            solution(next, row + next, column + next * 2);
            solution(next, row + next * 2, column);
            solution(next, row + next * 2, column + next);
            solution(next, row + next * 2, column + next * 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = " ";
            }
        }

        solution(n, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (String[] strings : arr) {
            for (String str : strings) {
                sb.append(str);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}