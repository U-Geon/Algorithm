import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    static void mergeSort(int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }
    // 5 4 3 & 2 1
    // 5 4 & 3
    // 0 0 1

    static void merge(int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int index = 0;

        // 1 3 4 7 (i)
        // 2 5 8 9 (j)
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }

        // 1 2 3 4
        // 5 6 7 8 일 때 남은 j와 i에 대한 정렬
        while(i <= mid) {
            tmp[index++] = arr[i++];
        }
        while(j <= end) {
            tmp[index++] = arr[j++];
        }

        for(int k = 0; k < tmp.length; k++) {
            arr[k + start] = tmp[k];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
