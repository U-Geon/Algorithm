import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] board;
    static int count = 0;
    static void solution(int index, int end) {
        if(index == end) {
            count++;
            return ;
        }

        for (int i = 0; i < end; i++) {
            board[index] = i;
            if(check(index)){
                solution(index + 1, end);
            }
        }
    }
    static boolean check(int x) {
        for (int i = 0; i < x; i++)
            if (board[i] == board[x] || Math.abs(i - x) == Math.abs(board[i] - board[x])) return false;
        return true;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }

        solution(0, n);
        System.out.println(count);
    }
}