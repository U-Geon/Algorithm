import java.util.*;
import java.io.*;

public class Main {

    static class Pos {
        int y, x;

        public Pos(String pos) {
            this.y = 8 - (pos.charAt(1) - '0');
            this.x = pos.charAt(0) - 'A';
        }

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Pos process(String order) {
        int dy = 0, dx = 0;
        switch (order) {
            case "T":  dy = -1; break;
            case "B":  dy = 1; break;
            case "L":  dx = -1; break;
            case "R":  dx = 1; break;
            case "RT": dy = -1; dx = 1; break;
            case "LT": dy = -1; dx = -1; break;
            case "RB": dy = 1; dx = 1; break;
            case "LB": dy = 1; dx = -1; break;
        }
        return new Pos(dy, dx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 알파벳 열, 숫자 행
        // 가장 왼쪽 A~H / 가장 아래 1 ~ 가장 위 8
        // T : 위, B : 아래, L , R
        // 킹이 돌을 같은 방향으로 밀어냄
        st = new StringTokenizer(br.readLine().trim());
        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        Pos kingPos = new Pos(king);
        Pos stonePos = new Pos(stone);

        for(int i = 0; i < n; i++) {
            String order = br.readLine().strip();

            Pos next = process(order);

            int nextKingY = kingPos.y + next.y;
            int nextKingX = kingPos.x + next.x;

            if (nextKingY < 0 || nextKingY >= 8 || nextKingX < 0 || nextKingX >= 8) continue;

            if (nextKingY == stonePos.y && nextKingX == stonePos.x) {
                int nextStoneY = stonePos.y + next.y;
                int nextStoneX = stonePos.x + next.x;

                if (nextStoneY < 0 || nextStoneY >= 8 || nextStoneX < 0 || nextStoneX >= 8) continue;

                stonePos.y = nextStoneY;
                stonePos.x = nextStoneX;
            }

            kingPos.y = nextKingY;
            kingPos.x = nextKingX;
        }

        String result1 = (char) (kingPos.x + 65) + "" + (8 - kingPos.y);
        String result2 = (char) (stonePos.x + 65) + "" + (8 - stonePos.y);

        System.out.println(result1);
        System.out.println(result2);
    }
}
