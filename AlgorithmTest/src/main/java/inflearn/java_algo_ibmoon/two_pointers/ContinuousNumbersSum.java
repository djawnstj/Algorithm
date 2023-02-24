package inflearn.java_algo_ibmoon.two_pointers;

/**
 * <strong>연속된 자연수의 합</strong><br/>
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.<br/>
 * 만약 N=15이면<br/>
 * 7+8=15<br/>
 * 4+5+6=15<br/>
 * 1+2+3+4+5=15<br/>
 * 와 같이 총 3가지의 경우가 존재한다.<br/>
 * <br/>
 * <strong>- 입력</strong><br/>
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.<br/>
 * <br/>
 * <strong>- 입력 예제 1</strong><br/>
 * 15<br/>
 * <br />
 * <strong>- 출력 예제 1</strong><br/>
 * 3
 */
public class ContinuousNumbersSum {
    public static void main(String[] args) {
        ContinuousNumbersSum T = new ContinuousNumbersSum();
        int n = 12;
        System.out.println(T.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        int m = (n / 2) + 1;
        int lt = 1;
        int sum = 0;

        for (int rt = 1; rt <= m; rt++) {
            sum += rt;
            if (sum == n) answer++;

            while (sum >= n) {
                sum -= lt++;
                if (sum == n) answer++;
            }
        }

        return answer;
    }
}
