import java.util.*;
import java.io.*;


public class Main {

    static int[] first, second;

    static List<Integer> solution(int n, int m) {

        List<Integer> result = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;

        while(firstIndex < n && secondIndex < m) {
            int maxValue = 0;
            for (int i = firstIndex; i < n; i++) {
                for (int j = secondIndex; j < m; j++) {
                    if(first[i] == second[j]) maxValue = Math.max(maxValue, first[i]);
                }
            }

            if(maxValue != 0) { // 일치하는 큰 값이 있다면 시작 인덱스 설정.
                result.add(maxValue);
                while(first[firstIndex] != maxValue) firstIndex++;
                while(second[secondIndex] != maxValue) secondIndex++;
                firstIndex++; secondIndex++;
            } else break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        first = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        second = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> solution = solution(n, m);
        System.out.println(solution.size());
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
