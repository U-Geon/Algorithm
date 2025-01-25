import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[][] maxValue = new int[n][3];
        int[][] minValue = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 0) {
                    maxValue[i][j] = arr[i][j];
                    minValue[i][j] = arr[i][j];
                } else {
                    maxValue[i][j] = Integer.MIN_VALUE;
                    minValue[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 누적합 구하기
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < 3; j++) {
                for(int k = j-1; k <= j+1; k++) {
                    if(k >= 0 && k < 3) {
                        maxValue[i+1][k] = Math.max(maxValue[i][j] + arr[i+1][k], maxValue[i+1][k]);
                        minValue[i+1][k] = Math.min(minValue[i][j] + arr[i+1][k], minValue[i+1][k]);
                    }
                }
            }
        }

        int result1 = Arrays.stream(maxValue[n-1]).max().getAsInt();
        int result2 = Arrays.stream(minValue[n-1]).min().getAsInt();

        System.out.println(result1 + " " + result2);
    }
}
