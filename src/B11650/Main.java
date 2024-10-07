package B11650;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] dots = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i][0] = x;
            dots[i][1] = y;
        }

        Arrays.sort(dots, Comparator.comparingInt((int[] o) -> o[0]).thenComparing(((int[] o) -> o[1])));

        for(int i = 0; i < N; i++) {
            bw.write(dots[i][0] + " " + dots[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
