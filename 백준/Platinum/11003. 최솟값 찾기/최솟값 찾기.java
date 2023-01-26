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

        Deque<Node> deq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!deq.isEmpty() && deq.getLast().value > cur) deq.removeLast();

            deq.addLast(new Node(i, cur));

            if (deq.getFirst().index <= i - L) deq.removeFirst();
            
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
