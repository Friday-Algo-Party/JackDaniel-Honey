package B7568_덩치;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int dchi = 0;
            int kg = arr[i][0];
            int cm = arr[i][1];
            for (int j = 0; j < N; j++) {
                if (arr[j][0] > kg && arr[j][1] > cm) {
                    dchi++;
                }
            }
            sb.append(dchi + 1).append(" ");
        }
        System.out.println(sb);
    }
}
