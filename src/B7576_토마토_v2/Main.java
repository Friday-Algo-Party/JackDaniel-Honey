package B7576_토마토_v2;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};
    static int N, M;
    static int[][] arr = new int[N][M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        int cnt = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);

    }

    public static int bfs() {
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean visited = false;

            for (int s = 0; s < size; s++) {
                Point p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    // 만약 Point 대신 int[]로 (x, y) 좌표를 저장했다면?
                    // int[] p = queue.poll();
                    // int nx = p[0] + dx[k];
                    // int ny = p[1] + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        visited = true;
                    }
                }
            }
            if (visited) {
                cnt++;
            }
        }
        return cnt;
    }
}
