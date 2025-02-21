package B2805_나무자르기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 집으로 가져가려는 나무의 길이

        int[] tree = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st1.nextToken());
            max = Math.max(max, tree[i]);
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            long cut = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    cut += tree[i] - mid;
                }
            }

            if (cut >= M) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            // low = 0, high = max에서 시작한 **이분 탐색**
            // O(N log max)

//            max--;
//            1씩 줄이면서 탐색하는 **완전탐색**
//            최악의 경우 max에서 0까지 내려가야 하므로 O(max * N)

        }
        System.out.println(answer);

    }
}
