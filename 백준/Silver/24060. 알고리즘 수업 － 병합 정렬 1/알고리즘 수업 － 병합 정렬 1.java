import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int n, target;
    static int k;
    static int count;

    static void merge_sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(start, mid);
            merge_sort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int t = 0;

        // 두 부분을 합치는 과정
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }

        // 남은 부분 처리
        while (i <= mid) tmp[t++] = arr[i++];
        while (j <= end) tmp[t++] = arr[j++];

        // tmp 배열을 원본 배열에 복사
        for (int value = 0; value < tmp.length; value++) {
            arr[start + value] = tmp[value];
            count++;
            if(count == k) target = arr[start + value];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        count = 0;
        target = -1;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, n-1);
        System.out.println(target);
    }
}