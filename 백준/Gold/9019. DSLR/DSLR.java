import java.io.*;
import java.util.*;

public class Main {

    static String[] array;
    static boolean[] visited;

    static String bfs(int a, int b) {
        int d,s,l,r,tmp;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;

        while(!queue.isEmpty()) {
            tmp = queue.poll();

            if(tmp == b) return array[b];

            int d1 = tmp == 0 ? 0 : tmp / 1000;
            int d2 = tmp == 0 ? 0 : tmp / 100 % 10;
            int d3 = tmp == 0 ? 0 : tmp / 10 % 10;
            int d4 = tmp == 0 ? 0 : tmp % 10;

            // D
            d = tmp * 2 % 10000;
            if(array[d].isEmpty() && !visited[d]) {
                array[d] = array[tmp] + "D";
                visited[d] = true;
                queue.add(d);
            }

            // S
            s = tmp == 0 ? 9999 : tmp - 1;
            if(array[s].isEmpty() && !visited[s]) {
                array[s] = array[tmp] + "S";
                queue.add(s);
            }

            // L
            l = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
            if(array[l].isEmpty() && !visited[l]) {
                array[l] = array[tmp] + "L";
                queue.add(l);
            }

            // R
            r = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
            if(array[r].isEmpty() && !visited[r]) {
                array[r] = array[tmp] + "R";
                queue.add(r);
            }
        }
        return array[b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            array = new String[10001];
            Arrays.fill(array, "");
            visited = new boolean[10001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(bfs(a, b));
        }
    }
}