package inflearn.java_algo_ibmoon.two_pointers;

/**
 * <strong>연속 부분수열</strong><br/>
 * N개의 수로 이루어진 수열이 주어집니다.<br/>
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.<br/>
 * 만약 N=8, M=6이고 수열이 다음과 같다면<br/>
 * 1 2 1 3 1 1 1 2<br/>
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.<br/>
 * <br/>
 * <strong>- 입력</strong><br/>
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.<br/>
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.<br/>
 * <br/>
 * <strong>- 입력 예제 1</strong><br/>
 * 8 6<br/>
 * 1 2 1 3 1 1 1 2<br/>
 * <br />
 * <strong>- 출력 예제 1</strong><br/>
 * 3
 */
public class ContinuousSubsequence {
    public static void main(String[] args) {
        ContinuousSubsequence T = new ContinuousSubsequence();
        int n = 8;
        int m = 6;
        int[] arr = {1, 2, 1, 3, 1, 1, 1, 2};

        System.out.println(T.solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0;
        int sum = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }
}
