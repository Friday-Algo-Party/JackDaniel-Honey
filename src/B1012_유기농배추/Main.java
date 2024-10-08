package B1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt = 0;
    static int M;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 위치의 개수
            int[][] farm = new int[M][N];

            // 배추가 심어져 있는 좌표를 1로 지정
            for (int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st2.nextToken());
                int Y = Integer.parseInt(st2.nextToken());
                farm[X][Y] = 1;
            }

            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    // 좌표가 1이라면
                    if(farm[x][y] == 1) {
                        cnt++;
                        dfs(farm, x, y);
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }

    public static void dfs(int[][] farm, int i, int j) {
        farm[i][j] = 0; // 다시 방문하지 않도록 현재 좌표를 0으로 만들어 줌
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= M || y < 0 || y >= N) {
                continue;
            }

            if (farm[x][y] == 1) {
                dfs(farm, x, y);
            }
        }
    }
}
