import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().strip();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        boolean flag = false; // 괄호 내에 있는지 여부

        for (int i = 0; i < line.length(); i++) {
            char word = line.charAt(i);

            if(word == '<') { // '<' 이면 그 이전까지 스택에 담은 것 다 넣기.
                flag = true;
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                queue.clear();
            }

            if(word == '>') { // >이 오면 queue에 담은 것들을 전부 빼내기.
                flag = false;
                while(!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
                sb.append(word);
                continue;
            }

            if(flag) { // 괄호 안에 있는 경우
                queue.add(word);
            } else if(!flag && word != ' ') { // 괄호 밖에 있는 경우
                stack.push(word);
            } else if(!flag && word == ' ') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
