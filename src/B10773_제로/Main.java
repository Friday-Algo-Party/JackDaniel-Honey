package B10773_제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> s = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < K; i++) {
            int money = Integer.parseInt(br.readLine());
            if (money == 0) {
                s.pop();
            } else {
                s.add(money);
            }
        }
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
        }
        System.out.println(sum);
    }
}
