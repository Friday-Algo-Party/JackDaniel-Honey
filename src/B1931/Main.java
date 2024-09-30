package B1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간

        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    // 끝나는 시간이 같다면 시작 시간 기준 정렬
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    // 끝나는 시간 기준 정렬
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int end = time[0][1];
        cnt++;

        for (int i = 1; i < N; i++) {
            if (time[i][0] >= end) {
                end = time[i][1];
                cnt++;
            } else {
                continue;
            }
        }

        System.out.println(cnt);


    }
}
