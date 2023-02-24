package inflearn.java_algo_ibmoon.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>가위 바위 보</strong><br/>
 * A, B 두 사람이 가위바위보 게임을 합니다. <br/>
 * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.<br/>
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.<br/><br/>
 * 예를 들어 N=5이면 <br/>
 * <pre>
 | 회수  | 1 | 2 | 3 | 4 | 5 |
 |-------|---|---|---|---|---|
 |   A   | 2 | 3 | 3 | 1 | 3 |
 |-------|---|---|---|---|---|
 |   B   | 1 | 1 | 2 | 2 | 3 |
 |-------|---|---|---|---|---|
 | 승자  | A | B | A | B | D |
 *</pre>
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 * <br /><br />
 * <strong>- 입력</strong><br />
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.<br/>
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.<br/>
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.<br/>
 * <br/>
 * <strong>- 입력 예제 1</strong><br/>
 * 5<br/>
 * 2 3 3 1 3 <br/>
 * 1 1 2 2 3 <br/>
 * <br/>
 * <strong>- 출력 예제 1</strong><br/>
 * A<br/>
 * B<br/>
 * A<br/>
 * B<br/>
 * D<br/>
 */
public class RockScissorsPaper {
    public static void main(String[] args) {
        RockScissorsPaper T = new RockScissorsPaper();

        int n = 5;
        int[] a = {2, 3, 3, 1, 3};
        int[] b = {1, 1, 2, 2, 3};

        for (String s : T.solution(n, a, b)) System.out.println(s);
    }

    public List<String> solution(int n, int[] a, int[] b) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer.add("D");
                continue;
            }

            switch (a[i]) {
                case 1 -> {
                    if (b[i] == 2) answer.add("B");
                    else if (b[i] == 3) answer.add("A");
                }
                case 2 -> {
                    if (b[i] == 1) answer.add("A");
                    else if (b[i] == 3) answer.add("B");
                }
                case 3 -> {
                    if (b[i] == 1) answer.add("B");
                    else if (b[i] == 2) answer.add("A");
                }
            }

        }

        return answer;
    }
}
