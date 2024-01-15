import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] sorted;
    static long count = 0;
    static void mergeSort(long[] arr, int left, int right) { // bubble Sort 보완
        if(left == right) return ;
        int mid = (left + right) / 2;
        mergeSort(arr,left, mid);
        mergeSort(arr,mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(long[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int index = left;

        while(l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                sorted[index] = arr[l];
                index += 1;
                l += 1;
            } else {
                sorted[index] = arr[r];
                index += 1;
                r += 1;
                count += mid - l + 1;
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[index] = arr[r];
                r += 1;
                index += 1;
            }
        } else {
            while(l <= mid) {
                sorted[index] = arr[l];
                l += 1;
                index += 1;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        sorted = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr,0, n-1);
        System.out.println(count);
    }
}