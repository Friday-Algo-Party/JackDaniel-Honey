package B2579_계단오르기_v2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = stairs[1];

        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[N]);

    }
}
