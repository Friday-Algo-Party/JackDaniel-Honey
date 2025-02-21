package B1654_랜선자르기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] lens = new int[K];

        int min = 1;
        int max = 0;

        for (int i = 0; i < K; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lens[i]);
        }

        max++;

        while (min < max) {
            int mid = (min + max) / 2;
            long temp = 0;

            for (int len : lens) {
                temp += len / mid;
            }

            if (temp < N) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min - 1);

    }
}
