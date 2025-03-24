package B18870_좌표압축;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] pressed = new int[N];

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pressed[arr[0][0]] = 0;

        for (int i = 1; i < N; i++) {
//            System.out.println(arr[i][0] + " " + arr[i][1]);
            if (arr[i][1] == arr[i - 1][1]) {
                pressed[arr[i][0]] = pressed[arr[i - 1][0]];
            } else {
                pressed[arr[i][0]] = pressed[arr[i - 1][0]] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(pressed[i]).append(" ");
        }

        System.out.println(sb);

    }
}
