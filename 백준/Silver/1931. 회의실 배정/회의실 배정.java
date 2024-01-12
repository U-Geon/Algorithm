import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if(this.second != other.second) {
                return Integer.compare(this.second, other.second);
            } else if(this.second == other.second) {
                return Integer.compare(this.first, other.first);
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int count = 1;
        ArrayList<Pair> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.add(new Pair(start, end));
        }

        Collections.sort(arr);

        int before = arr.get(0).second;

        for (int i = 1; i < n; i++) {
            if(arr.get(i).first >= before) {
                count += 1;
                before = arr.get(i).second;
            }
        }

        System.out.println(count);
    }
}