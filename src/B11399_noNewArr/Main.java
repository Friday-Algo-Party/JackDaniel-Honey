package B11399_noNewArr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            arr[i] += arr[i - 1];
            sum += arr[i];
        }

        System.out.println(sum);

    }

}
