package B11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N + 1];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            // 가치가 큰 것부터 for문 돌면서
            // K를 해당 가치로 나눈 값이 1보다 작으면 넘어가고
            if(K / coins[i] < 1) {
                continue;
            }
            // K를 해당 가치로 나누어서 1 이상이면
            else {
                cnt += K / coins[i]; // K를 가치로 나눈 몫을 cnt에 더해주고
                K = K % coins[i]; // K는 그 나머지로 다시 설정한다.
            }
        }

        System.out.println(cnt);
    }
}
