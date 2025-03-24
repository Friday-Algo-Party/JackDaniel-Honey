package B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> card = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            card.offer(i);
        }

        while (card.size() > 1) {
            card.poll();
            card.offer(card.poll());
        }
        System.out.println(card.poll());
    }
}
