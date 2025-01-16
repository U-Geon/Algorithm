import java.io.*;
import java.util.*;

public class Main {
    // 삭제된 값을 추적하기 위한 Map (최소힙, 최대힙 각각에 대해)
    static Map<Integer, Integer> deletedMin = new HashMap<>();
    static Map<Integer, Integer> deletedMax = new HashMap<>();

    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

    static void process(String order, int number) {
        if (order.equals("D")) {

            if(number == -1) { // 최솟값 삭제 연산
                // minQueue에서 삭제된 값(최댓값)이 존재한다면, 값을 계속 버리기 (큐 동기화)
                while(!minQueue.isEmpty() && deletedMin.getOrDefault(minQueue.peek(), 0) > 0) {
                    int removedMin = minQueue.poll();
                    deletedMin.put(removedMin, deletedMin.get(removedMin) - 1);
                }

                // 만약 minQueue에 값이 존재한다면 최대 큐에서도 삭제해줘야 함.
                if (!minQueue.isEmpty()) {
                    int removedMin = minQueue.poll();
                    deletedMax.put(removedMin, deletedMax.getOrDefault(removedMin, 0) + 1);
                }

            } else if(number == 1) { // 최댓값 삭제 연산
                // maxQueue에서 삭제된 값(최솟값)이 존재한다면, 값을 계속 버리기 (큐 동기화)
                while (!maxQueue.isEmpty() && deletedMax.getOrDefault(maxQueue.peek(), 0) > 0) {
                    int removedMax = maxQueue.poll();  // 삭제된 값이 있으면 그 값을 계속 버림
                    deletedMax.put(removedMax, deletedMax.get(removedMax) - 1);
                }

                // maxQueue에 값이 존재하는 경우, 최소 큐에서도 이 값을 삭제해야 함.
                if (!maxQueue.isEmpty()) {
                    int removedMax = maxQueue.poll();
                    deletedMin.put(removedMax, deletedMin.getOrDefault(removedMax, 0) + 1);
                }
            }
        } else { // order = I
            minQueue.add(number);
            maxQueue.add(number);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < t; i++) {

            int k = Integer.parseInt(br.readLine()); // 연산의 개수
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken(); // 명령어 (I 또는 D)
                int number = Integer.parseInt(st.nextToken()); // 숫자

                process(order, number);
            }

            // 결과 출력 (큐 동기화)
            while (!minQueue.isEmpty() && deletedMin.getOrDefault(minQueue.peek(), 0) > 0) {
                int removedMin = minQueue.poll();
                deletedMin.put(removedMin, deletedMin.get(removedMin) - 1);
            }
            while (!maxQueue.isEmpty() && deletedMax.getOrDefault(maxQueue.peek(), 0) > 0) {
                int removedMax = maxQueue.poll();
                deletedMax.put(removedMax, deletedMax.get(removedMax) - 1);
            }

            if (minQueue.isEmpty() || maxQueue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQueue.peek() + " " + minQueue.peek());
            }

            // 결과 출력 후, 큐와 삭제 기록을 초기화
            minQueue.clear();
            maxQueue.clear();
            deletedMin.clear();
            deletedMax.clear();
        }
    }
}
