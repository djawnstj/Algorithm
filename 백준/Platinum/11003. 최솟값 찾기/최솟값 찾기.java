import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // Deque: 앞/뒤 양쪽으로 값을 추가하거나 삭제할 수 있음
        Deque<Node> deq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        // N개의 수만큼 받아서 바로 비교함으로써, 시간복잡도를 줄일 수 있음
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            // 최소값을 구하는 문제이므로, 현재 deque 내에서 입력받은 값보다 큰 값이 존재하면 삭제하면서 정렬 효과를 냄
            while (!deq.isEmpty() && deq.getLast().value > cur) deq.removeLast();

            // deque의 최대값으로 최근 입력받은 값 추가
            deq.addLast(new Node(i, cur));

            // 가장 첫번째 값이 현재 index로부터 L 이상 멀어졌으면 슬라이딩 윈도우를 벗어난것이므로 가장 첫번째 값 삭제
            if (deq.getFirst().index <= i - L) deq.removeFirst();

            // 가장 첫번째 값이 최소값이므로 첫번째 값을 공백과 함께 문자열에 추가
            bw.write(deq.getFirst().value + " ");

        }

        bw.flush();
        bw.close();

    }

    static class Node {
        public final int index;
        public final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
