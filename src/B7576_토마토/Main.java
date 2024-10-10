package B7576_토마토;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] box;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int M, N;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st2.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        int cnt = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
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
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1; // 토마토 익음
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