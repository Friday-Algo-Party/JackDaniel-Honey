package B9012_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String inputData = br.readLine();
            // isVPS가 true면 "YES", false면 "NO" 출력
            if(isVPS(inputData)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isVPS(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 여는 괄호면 스택에 push
            if (c == '(') {
                stack.push(c);
            }
            // 닫는 괄호라면
            else if (c == ')') {
                // 스택이 비어있으면 함께 pop할 여는 괄호가 없으므로 false
                if (stack.empty()) {
                    return false;
                }
                // 그게 아니라면 직전 여는 괄호 pop
                else {
                    stack.pop();
                }
            }
        }

        // stack이 비었으면 true, 값이 남았다면 false를 return
        return stack.empty();
    }
}
