import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine().strip();

        // 남쪽을 보고 서있음.
        // F : 앞으로 한칸, L, R : 방향 전환
        // 전부 F임을 가정하고 홍준이가 정 가운데에 있다고 가정하면, 배열의 크기는 100 * 100이 좋을듯
        char[][] map = new char[101][101];

        // 홍준이의 위치
        int startX = 50;
        int startY = 50;

        // 최대 범위
        int maxX = 50;
        int maxY = 50;
        int minX = 50;
        int minY = 50;

        map[startY][startX] = '.';

        // 방향 (y, x)
        int[][] direction = {{1,0}, {0,-1}, {-1,0}, {0,1}};
        int directionIndex = 0; // index가 증가하면 반시계, 감소하면 시계

        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == 'F') { // 직진
                startY += direction[directionIndex][0];
                startX += direction[directionIndex][1];

                maxX = Math.max(maxX, startX);
                maxY = Math.max(maxY, startY);
                minX = Math.min(minX, startX);
                minY = Math.min(minY, startY);
            } else if(line.charAt(i) == 'L') { // 반시계 회전
                directionIndex = (directionIndex + 3) % 4;
            } else { // 시계 회전
                directionIndex = (directionIndex + 1) % 4;
            }
            map[startY][startX] = '.';
        }

        StringBuilder sb = new StringBuilder();

        for(int i = minY; i <= maxY; i++) {
            for(int j = minX; j <= maxX; j++) {
                if(map[i][j] == '.') {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
