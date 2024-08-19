import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10001];
        arr[0] = -1;
        arr[1] = -1;
        for (int i = 2; i < 10001; i++) {
            if(arr[i] == 1) continue;
            for (int j = i * i; j < 10001; j += i) {
                arr[j] = 1;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            for (int j = tmp / 2; j >= 2; j--) {
                if(arr[tmp - j] == 0 && arr[j] == 0) {
                    System.out.println(j + " " + (tmp - j));
                    break;
                }
            }
        }
    }
}