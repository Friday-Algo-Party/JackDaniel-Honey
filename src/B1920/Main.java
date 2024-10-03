package B1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 배열에 집어넣고
        // M개의 수 돌며 배열에 contains면 1 아니면 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> A = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.valueOf(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            int num = Integer.parseInt(st2.nextToken());
            if (A.contains(num)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            if (j != M - 1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
