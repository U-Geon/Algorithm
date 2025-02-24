import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            // 1. 피연산자(알파벳)는 바로 출력
            if (Character.isLetter(c)) {
                sb.append(c);
            }

            // 2. 연산자
            // * / 는 + - 보다 먼저 계산해야 하므로, precedence() 메서드로 우선순위 비교
            // 연산자 스택에서 현재 연산자보다 우선순위가 높거나 같은 연산자 는 pop() 후 결과에 추가
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }

            // 3. 여는 괄호 '('
            else if (c == '(') {
                stack.push(c);
            }

            // 4. 닫는 괄호 ')'
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            }
        }

        // 5. 스택에 남아 있는 연산자 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    // 연산자 우선순위 반환 메서드
    static int precedence(char op) {
        if (op == '(' || op == ')') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }
}
