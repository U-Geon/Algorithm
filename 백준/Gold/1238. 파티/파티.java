import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    int next, weight;

    public Student(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student o) {
        if(this.weight != o.weight) {
            return Integer.compare(this.weight, o.weight);
        }
        return 0;
    }
}

public class Main {

    static int[] dijkstra(ArrayList<ArrayList<Student>> graph, Student student) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, 100000000);
        boolean[] visited = new boolean[graph.size()];

        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(student);
        dist[student.next] = 0;

        while(!pq.isEmpty()) {
            Student curr = pq.poll();
            visited[curr.next] = true;

            ArrayList<Student> students = graph.get(curr.next);

            for (int i = 0; i < students.size(); i++) {
                Student neighbor = students.get(i);

                if(!visited[neighbor.next] && dist[neighbor.next] > dist[curr.next] + neighbor.weight) {
                    dist[neighbor.next] = dist[curr.next] + neighbor.weight;
                    pq.add(new Student(neighbor.next, dist[neighbor.next])); // 거리가 갱신된 노드를 삽입해야 함.
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Student>> graph = new ArrayList<>();
        ArrayList<ArrayList<Student>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(new Student(b, c));
            reversedGraph.get(b).add(new Student(a, c));
        }

        int[] xToHomeDistance = dijkstra(graph, new Student(x, 0));
        int[] homeToXDistance = dijkstra(reversedGraph, new Student(x, 0));
        int maxValue = -1;

        for (int i = 1; i < n + 1; i++) {
            maxValue = Math.max(maxValue, xToHomeDistance[i] + homeToXDistance[i]);
        }

        System.out.println(maxValue);
    }
}
