import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    static int blue = 0;
    static int white = 0;
    static void solution(int x1, int x2, int y1, int y2) {

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        int flag = arr.get(y1).get(x1);

        if(x1 == x2 && y1 == y2) {
            if(flag == 1) blue += 1;
            else white += 1;
            return;
        }

        boolean sameColor = true;
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if(flag != arr.get(i).get(j)) {
                    sameColor = false;
                    break;
                }
            }
        }

        if (sameColor) {
            if(flag == 1) blue += 1;
            else white += 1;
        } else {
            solution(x1, midX, y1, midY);
            solution(midX + 1, x2, y1, midY);
            solution(x1, midX, midY + 1, y2);
            solution(midX + 1, x2, midY + 1, y2);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            arr.add(tmp);
        }

        solution(0,n-1, 0, n-1);

        System.out.println(white);
        System.out.println(blue);
    }
}