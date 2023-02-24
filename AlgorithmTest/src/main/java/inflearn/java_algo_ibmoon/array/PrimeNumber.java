package inflearn.java_algo_ibmoon.array;

/**
 * <strong>소수(에라토스테네스 체)</strong><br/>
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.<br/>
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.<br/>
 * <br/>
 * <strong>- 입력</strong><br/>
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.<br/>
 * <br/>
 * <strong>- 입력 예제 1</strong><br/>
 * 20<br/>
 * <br />
 * <strong>- 출력 예제 1</strong><br/>
 * 8
 */
public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber T = new PrimeNumber();
        int n = 20;

        System.out.println(T.solution(n));

    }

    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) arr[j] = 1;
            }
        }
        return answer;
    }
}
