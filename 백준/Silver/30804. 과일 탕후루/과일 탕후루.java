import java.io.*;
import java.util.*;

/**
* 투 포인터 문제.
* 왼쪽부터 탕후루를 끼면서 종류 개수 탐색.
* 종류가 2개 이상일 경우 왼쪽 제거.
* 매 경과마다 최대 개수 저장.
*/
public class Main {

    static int[] array;

    static int solution(int t) {
        int left = 0;
        int right = 0;

        int[] type = new int[11];
        int typeCount = 0;

        int result = 0;

        while (right < t) {
            if(type[array[right]] == 0) {
                typeCount++;
            }

            type[array[right]]++;

            while(typeCount > 2) {
                type[array[left]]--;
                if(type[array[left]] == 0) typeCount--;
                left++;
            }
            right++;
            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[t];

        for (int i = 0; i < t; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(t));
    }
}