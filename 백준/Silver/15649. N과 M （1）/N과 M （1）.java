import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();
    static void solution(int n, int m) {
        if(arr.size() == m) {
            for (Integer i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return ;
        }
        for (int i = 1; i < n+1; i++) {
            if(!arr.contains(i)) {
                arr.add(i);
                solution(n, m);
                arr.remove(arr.size()-1);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n,m);
    }
}