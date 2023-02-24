package inflearn.java_algo_ibmoon.array;

import java.util.ArrayList;

/**
 * <strong>큰 수 출력하기</strong><br />
 * N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.<br />
 * (첫 번째 수는 무조건 출력)
 * <br />
 * <br />
 * <strong>- 입력</strong><br />
 * 첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 * <br />
 * <br />
 * <strong>- 입력 예제 1</strong><br />
 * 6<br />
 * 7 3 9 5 6 12
 * <br />
 * <br />
 * <strong>- 출력 예제 1</strong><br />
 * 7 9 6 12
 */
public class PrintLargeNumber {
    public static void main(String[] args) {
        PrintLargeNumber T = new PrintLargeNumber();

        int n = 6;
        int[] arr = new int[]  {7, 3, 9, 5, 6, 12};

        for (int i : T.solution(n, arr)) System.out.print(i + " ");

    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) answer.add(arr[i]);
        }

        return answer;
    }
}
