package B11399;

import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int[] sumArr;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sumArr = new int[N + 1];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개만큼 한 줄에 숫자 입력 받음
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최솟값 구하기 위해 오름차순 sort
        Arrays.sort(arr);

        // sumArr에 각 index까지의 합을 넣어줌
        for (int i = 1; i <= N; i++) {
            for (int j = i; j >= 1; j--) {
                sumArr[i] += arr[j];
            }
        }

        // sumArr에 저장된 값들의 합
        for (int i = 1; i <= N; i++) {
            sum += sumArr[i];
        }

        System.out.println(sum);

    }

}
