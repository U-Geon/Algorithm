import java.io.*;
import java.util.*;

public class Main {

    static int[] arr, LIS;

    static int solution(int n) {
        LIS[0] = arr[0];
        int index = 0;

        // arr의 두번째부터 마지막까지 하나씩 LIS와 비교하면서 넣기.
        for(int i = 1; i < n; i++){
            // lis의 마지막 원소가 현재값 보다 작다면,
            // lis에는 현재 값의 lowerbound가 존재하지 않는다. 그러므로 그대로 넣어준다.
            if(LIS[index] < arr[i]){
                index++;
                LIS[index] = arr[i];
            } else {
                // lis배열에서 arr[i]의 lowerbound값에 해당하는 index를 찾는다.
                int idx = binarySearch(0, index, arr[i]);
                // 현재 값으로 치환
                LIS[idx] = arr[i];
            }
        }

        return index + 1;
    }

    static int binarySearch(int left, int right, int target) {
        int mid;

        while(left < right) { // 1 2 9
            mid = (left + right) / 2;
            if(LIS[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        LIS = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n));


    }
}
