package B2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N = 0;
    static int cnt = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] village = new int[N][N];  // 배열 크기를 N으로 변경
        ArrayList<Integer> sameVillage = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                village[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(village[i][j] == 1) {
                    cnt = 0;
                    dfs(village, i, j);
                    sameVillage.add(cnt);
                }
            }
        }

        Collections.sort(sameVillage);
        System.out.println(sameVillage.size());  // 단지 수 출력
        for (int num : sameVillage) {
            System.out.println(num);  // 각 단지 크기 출력
        }
    }

    public static void dfs(int[][] village, int i, int j) {
        cnt++;
        village[i][j] = 0;

        for(int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= N || y < 0 || y >= N) {
                continue;
            }

            if(village[x][y] == 1) {
                dfs(village, x, y);
            }
        }
    }
}
