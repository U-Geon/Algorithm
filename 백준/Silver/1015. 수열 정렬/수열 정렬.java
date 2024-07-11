import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
            arr[i][2] = -1;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            arr[i][2] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        for (int[] ints : arr) {
            System.out.print(ints[2] + " ");
        }
    }
}

//2 3 1
//b[p[1]] = a[1] // b[p[2]] = 1
//b[p[0]] = a[0] // b[p[0]] = 2
//b[p[1]] = a[1] // b[p[1]] = 3
//
//1 2 3
//p[2] = 0
//p[0] = 1
//p[1] = 2