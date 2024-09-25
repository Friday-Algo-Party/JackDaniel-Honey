package B11725_트리의부모찾기;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        // 리스트 초기화
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            tree.get(num1).add(num2);
            tree.get(num2).add(num1);
        }

        BFS(1);

//        for(int i = 2; i <= N; i++) {
//            System.out.println(parent[i]);
//        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(num); // 시작 노드 num을 큐에 넣는다
        visited[num] = true; // 방문한 노드인 num을 방문 처리한다.

        while(!queue.isEmpty()) { // 더 이상 방문할 노드 없을 때까지 탐색
            Integer cur = queue.poll(); // 큐의 맨 앞 노드 꺼내서 cur에 저장

            for (Integer next : tree.get(cur)) { // 현재 노드와 연결된 모든 인접 노드 가져옴
                if(!visited[next]) { // 인접 노드 next의 방문 여부 확인, 아직 방문하지 않았다면
                    queue.offer(next); // 큐에 추가
                    visited[next] = true; // 방문 처리
                    parent[next] = cur; // next 노드의 부모 노드를 현재 노드로 설정
                    // next가 cur로부터 탐색되었다.
                }
            }
        }
    }
}
