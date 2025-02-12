import java.util.*;
import java.io.*;

class Node {
    int x, y, value;

    public Node(int y, int x, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class Main {
    /**
     * 확산되는 양 : Arc // 5
     * 확산되고 남은 양 : Arc - 확산되는 양 * 4
     */
    static int r, c, t;
    static int[][] arr;
    static List<Node> dust = new ArrayList<>();

    // 확산
    static void diffusion() {
        int[][] distance = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        for (Node node : dust) {
            int x = node.x;
            int y = node.y;
            int tmp = node.value / 5;

            if (arr[y][x] < 5) continue; // 확산 못하는 경우

            for (int[] ints : distance) {
                int ny = y + ints[0];
                int nx = x + ints[1];

                if (nx >= 0 && ny >= 0 && nx < c && ny < r) {
                    if (arr[ny][nx] != -1) {

                        arr[ny][nx] += tmp;
                        arr[y][x] -= tmp;
                    }
                }
            }
        }
    }

    static void circulate(int airConditionalRow) {
        // 반시계 방향 순환
        int upper = airConditionalRow - 1;
        for (int i = upper - 1; i > 0; i--) arr[i][0] = arr[i - 1][0]; // ↓
        for (int i = 0; i < c - 1; i++) arr[0][i] = arr[0][i + 1]; // →
        for (int i = 0; i < upper; i++) arr[i][c - 1] = arr[i + 1][c - 1]; // ↑
        for (int i = c - 1; i > 1; i--) arr[upper][i] = arr[upper][i - 1]; // ←
        arr[upper][1] = 0;

        // 시계 방향 순환
        int lower = airConditionalRow;
        for (int i = lower + 1; i < r - 1; i++) arr[i][0] = arr[i + 1][0]; // ↑
        for (int i = 0; i < c - 1; i++) arr[r - 1][i] = arr[r - 1][i + 1]; // →
        for (int i = r - 1; i > lower; i--) arr[i][c - 1] = arr[i - 1][c - 1]; // ↓
        for (int i = c - 1; i > 1; i--) arr[lower][i] = arr[lower][i - 1]; // ←
        arr[lower][1] = 0;

        // 기존 먼지 위치들 갱신
        dust.clear();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j] > 0) dust.add(new Node(i, j, arr[i][j]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        t = Integer.parseInt(st.nextToken()); // 시간

        arr = new int[r][c];

        int airConditionalRow = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int integer = Integer.parseInt(st.nextToken());
                arr[i][j] = integer;

                if(integer > 0) dust.add(new Node(i, j, integer));
                if(integer == -1) airConditionalRow = i;
            }
        }

        for (int i = 0; i < t; i++) {
            diffusion();
            circulate(airConditionalRow);
        }

        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt > 0) sum += anInt;
            }
        }

        System.out.println(sum);
    }
}
