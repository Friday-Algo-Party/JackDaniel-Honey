package B16236_아기상어;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 0, 1}; // 상, 하
    static int[] dx = {0, -1, 1, 0}; // 좌, 우

    static int N; // 공간 크기 (N x N)
    static int[][] space; // 공간 상태

    static int size = 2; // 아기 상어 크기 (2로 시작)
    static int remain = 2; // 성장까지 남은 먹이 개수
    static int curx, cury; // 현재 아기 상어 위치

    // 우선순위 큐에서 사용할 노드 클래스
    static class Node {
        int x, y;
        int dist; // 이동 거리

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());

                if (space[i][j] == 9) {
                    cury = i; // 행 (위아래 이동)
                    curx = j; // 열 (좌우 이동)
                    space[i][j] = 0; // 아기상어의 위치는 지나갈 수 있으므로 0
                }
            }
        }

        int time = 0;
        while (true) {
            int ret = bfs(cury, curx);

            if (ret == -1) break;
            // 더 이상 먹을 수 있는 물고기가 없으면 종료

            time += ret; // 이동 시간 추가
            remain--; // 물고기 1마리 먹음

            if (remain == 0) {
                size++; // 아기 상어 성장
                remain = size; // 다시 바뀐 크기만큼 물고기를 먹어야 한다
            }
        }

        System.out.println(time);

    }

    public static int bfs(int y, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.dist == o2.dist && o1.y == o2.y) return o1.x - o2.x;

                else if (o1.dist == o2.dist) return o1.y - o2.y;

                return o1.dist - o2.dist;

                // 정렬 기준 (가장 가까운 물고기 -> 가장 위쪽 -> 가장 왼쪽)
                // 1. 거리가 짧은 순서
                // 2. 같은 거리라면 더 위쪽
                // 3. 같은 y라면 더 왼쪽
            }
        });

        pq.add(new Node(x, y, 0)); // 현재 위치에서 시작

        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;

        int cnt;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (space[cur.y][cur.x] > 0 &&
                    space[cur.y][cur.x] < size // 아기상어보다 작은 경우
                ) {
                space[cur.y][cur.x] = 0; // 물고기 먹기
                curx = cur.x;
                cury = cur.y;
                cnt = cur.dist; // 이동 거리 저장

                return cnt; // 먹었으니 현재 이동 거리 반환
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[ny][nx]) continue; // 이미 방문한 곳이면 건너뛰기
                if (space[ny][nx] > size) continue; // 더 큰 물고기면 못 지나감

                visited[ny][nx] = true;
                pq.add(new Node(nx, ny, cur.dist + 1)); // 새로운 위치 탐색
            }
        }
        return -1;
        // 먹을 수 있는 물고기가 없으면 -1 반환 (탐색 종료)
    }
}
