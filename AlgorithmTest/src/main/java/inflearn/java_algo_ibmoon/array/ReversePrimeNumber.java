package inflearn.java_algo_ibmoon.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>뒤집은 소수</strong><br/>
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.<br/>
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.<br/>
 * 첫 자리부터의 연속된 0은 무시한다.<br/>
 * <br/>
 * <strong>- 입력</strong><br/>
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.<br/>
 * 각 자연수의 크기는 100,000를 넘지 않는다.<br/>
 * <br/>
 * <strong>- 입력 예제 1</strong><br/>
 * 9<br/>
 * 32 55 62 20 250 370 200 30 100<br/>
 * <br />
 * <strong>- 출력 예제 1</strong><br/>
 * 23 2 73 2 3
 */
public class ReversePrimeNumber {
    public static void main(String[] args) {

    }

    public List<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int res = 0;

            while (temp > 0) {
                int t = temp % 10;
                res = res * 10 + t;
                temp /= 10;
            }

            if (isPrime(res)) answer.add(res);
        }


        return answer;
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num%1 == 0) return false;
        }
        return true;
    }
}
