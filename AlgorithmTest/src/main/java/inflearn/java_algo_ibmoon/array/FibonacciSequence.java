package inflearn.java_algo_ibmoon.array;

import java.util.ArrayList;

/**
 * <strong>피보나치 수열</strong><br/>
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.<br/>
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.<br/>
 * <br/>
 * <strong>- 입력</strong><br/>
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.<br/>
 * <br/>
 * <strong>- 입력 예제 1</strong><br/>
 * 10<br/>
 * <br />
 * <strong>- 출력 예제 1</strong><br/>
 * 1 1 2 3 5 8 13 21 34 55
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        FibonacciSequence T = new FibonacciSequence();

        int n = 10;

        for (Integer i : T.solution(n)) {
            System.out.print(i + " ");
        }

    }

    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(1);
        answer.add(1);

        for (int i = 2; i < n; i++) {
            int temp = answer.get(i - 2) + answer.get(i - 1);
            answer.add(temp);
        }

        return answer;
    }
}
