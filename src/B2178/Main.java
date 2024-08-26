package B2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = line.charAt(j - 1) - '0'; // char 값을 int로 변환
            }
        }
        bfs();

    }
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1}); // 시작 위치 삽입
        visited[1][1] = true; // 시작 위치 방문 처리

        while(!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치 꺼냄
            int x = current[0];
            int y = current[1];

            // (N, M)에 도착한 경우, 그 위치의 값을 출력하고 종료
            if (x == N && y == M) {
                System.out.println(maze[x][y]);
                return;
            }

            // 상하좌우 이동하면서 BFS 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 범위 벗어나지 않도록 체크
                if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true; // 방문 처리
                        maze[nx][ny] = maze[x][y] + 1; // 현재 칸 까지의 거리 + 1
                        queue.add(new int[]{nx, ny}); // 큐에 새 위치 추가
                    }
                }
            }
        }

    }
}
