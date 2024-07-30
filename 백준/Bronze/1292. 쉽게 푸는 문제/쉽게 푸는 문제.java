import java.io.*;
import java.util.*;

public class Main {

    static int solution(int start, int end) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= 500; i++) {
            for (int j = 0; j < i; j++) {
                arr.add(i);
            }
        }

        int sum = 0;
        for (int i = start - 1; i < end; i++) {
            sum += arr.get(i);
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, m));
    }
}