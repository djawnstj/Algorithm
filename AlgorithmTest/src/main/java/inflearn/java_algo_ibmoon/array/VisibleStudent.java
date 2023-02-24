package inflearn.java_algo_ibmoon.array;

/**
 * <strong>보이는 학생</strong><br />
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, <br/>
 * 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. <br/>
 * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 * <br />
 * <br />
 * <strong>- 입력</strong><br />
 * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 * <br />
 * <br />
 * <strong>- 입력 예제 1</strong><br />
 * 8<br />
 * 130 135 148 140 145 150 150 153
 * <br />
 * <br />
 * <strong>- 출력 예제 1</strong><br />
 * 5
 */
public class VisibleStudent {
    public static void main(String[] args) {
        VisibleStudent T = new VisibleStudent();

        int n = 8;
        int[] arr = new int[]  {130, 135, 148, 140, 145, 150, 150, 153};

        System.out.print(T.solution(n, arr));
    }

    public int solution(int n, int[] arr) {
        int answer = 1;
        int temp = arr[0];

        for (int i = 1; i < n; i++) {
            if (temp < arr[i]) {
                answer++;
                temp = arr[i];
            }
        }

        return answer;
    }
}
