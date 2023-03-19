
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int answer = 0;
    static int[] ch;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ch = new int[k];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            queue = BFS(queue, k);
        }

        System.out.println(answer);

    }

    public static Queue<Integer> BFS(Queue<Integer> queue, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        answer++;

        for (Integer it : list) {
            int i = it.intValue() + 1;
            int j = it.intValue() * 2;

            if (i == k) return new LinkedList<>();
            else if (i < k && ch[i] == 0) {
                ch[i] = 1;
                result.offer(i);
            }

            if (j == k) return new LinkedList<>();
            else if (j < k && ch[j] == 0) {
                ch[j] = 1;
                result.offer(j);
            }
        }

        return result;
    }

}

