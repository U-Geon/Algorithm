import java.util.*;
import java.io.*;

class Person {
    int next, time;

    public Person(int next, int time) {
        this.next = next;
        this.time = time;
    }
}

public class Main {

    static int minTime = Integer.MAX_VALUE;
    static int count = 1;

    // BFS
    static void solution(int subin, int brother) {
        Queue<Person> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new Person(subin, 0));

        while(!queue.isEmpty()) {
            Person poll = queue.poll();
            if(poll.next == brother) {
                if(minTime > poll.time) {
                    count = 1;
                    minTime = poll.time;
                }
                else if(minTime == poll.time) {
                    count++;
                }
                continue;
            }

            visited[poll.next] = true;

            int[] nextPosition ={poll.next * 2, poll.next + 1, poll.next - 1};

            for (int next : nextPosition) {
                if(next >= 0 && next <= 100000) {
                    if(!visited[next] || next == brother) { // 방문 하지 않았거나, brother에게 방문하는 경우
                        queue.add(new Person(next, poll.time + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
            System.out.println(1);
            return ;
        }

        solution(n, k);

        System.out.println(minTime);
        System.out.println(count);
    }
}