import java.io.*;
import java.util.*;

public class Main {

    static int[][] status;
    static boolean[] visited;
    static int n, minValue;

    /**
     * @param parent 현재 루프에서 부모 숫자
     * @param index 현재 방문한 숫자
     */
    static void solution(int parent, int index) {
        if(index == n/2) {
            int start = 0, link = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j) continue;

                    if(visited[i] && visited[j]) start += status[i][j];
                    else if(!visited[i] && !visited[j]) link += status[i][j];
                }
            }
            minValue = Math.min(minValue, Math.abs(start - link));
            return ;
        }

        // 1 ~ 6까지 숫자 중 중복 없이 3개를 선택해야 함.
        for (int i = parent; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(i + 1, index + 1);

                visited[i] = false;
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        minValue = Integer.MAX_VALUE;

        status = new int[n][n]; // 스타트링크 점수
        visited = new boolean[n]; // 1~n까지 숫자 중 방문 여부

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 2 3을 택하는 경우와 4 5 6을 택하는 경우가 같음
        // 연산 횟수를 절반으로 줄이기 위해 1을 반드시 포함하는 경우만 고려하기
        visited[0] = true;
        solution(1, 1);
        System.out.println(minValue);
    }
}
