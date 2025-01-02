import java.util.*;
import java.io.*;

class Balloon {
    int index, paper;

    public Balloon(int index, int paper) {
        this.index = index;
        this.paper = paper;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Balloon> balloons = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            balloons.addLast(new Balloon(i, num));
        }

        StringBuilder sb = new StringBuilder();

        boolean leftOrRight = true; // left = true

        while(!balloons.isEmpty()) {
            Balloon b = leftOrRight ? balloons.pollFirst() : balloons.pollLast();
            sb.append(b.index).append(" ");

            if(balloons.isEmpty()) break;

            if(b.paper > 0) {
                for (int i = 0; i < b.paper - 1; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
                leftOrRight = true;
            } else {
                for (int i = b.paper; i < -1; i++) {
                    balloons.addFirst(balloons.pollLast());
                }
                leftOrRight = false;
            }
        }

        System.out.println(sb);
    }
}