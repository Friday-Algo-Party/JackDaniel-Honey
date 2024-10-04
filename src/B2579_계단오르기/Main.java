package B2579_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N + 1];
        int[] maxScore = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        maxScore[1] = scores[1];
        maxScore[2] = scores[1] + scores[2];

        for (int i = 3; i <= N; i++) {
            maxScore[i] = Math.max(maxScore[i-2], maxScore[i-3] + maxScore[i-1] + scores[i]);
        }
        System.out.println(maxScore[N]);
    }
}
