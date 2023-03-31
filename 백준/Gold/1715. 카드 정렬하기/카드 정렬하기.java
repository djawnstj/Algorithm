
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Card implements Comparable<Card> {

        public final int num;
        public Card(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Card o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Card> pQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pQ.offer(new Card(Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        while (pQ.size() > 1) {
            Card cur1 = pQ.poll();
            Card cur2 = pQ.poll();
            answer += cur1.num;
            answer += cur2.num;
//            System.out.println("cur1: " + cur1.num + ", cur2: " + cur2.num + ", result: " + (cur1.num + cur2.num));
            pQ.offer(new Card(cur1.num + cur2.num));
        }

        System.out.println(answer);

    }

}

