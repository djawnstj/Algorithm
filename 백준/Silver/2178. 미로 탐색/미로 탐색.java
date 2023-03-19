
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] ch;

    static final int[] disX = {0, 1, 0, -1};
    static final int[] disY = {1, 0, -1, 0};

    static int answer = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        ch = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] s = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++) arr[i][j + 1] = Integer.valueOf(String.valueOf(s[j]));
        }

        if (arr[1][1] == 0) {
            System.out.println(0);
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(1, 1));

        bfs(queue, m + 1, n + 1);

        System.out.println(arr[n][m]);

    }

    public static void bfs(Queue<Node> queue, int limitX, int limitY) {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = node.x + disX[i];
                int newY = node.y + disY[i];

                if (newX > 0 && newX < limitX && newY > 0 && newY < limitY && ch[newY][newX] == 0 && arr[newY][newX] != 0) {
                    queue.offer(new Node(newX, newY));
                    arr[newY][newX] = arr[node.y][node.x] + 1;
                    ch[newY][newX] = 1;

                    if (newX == limitX - 1 && newY == limitY - 1) return;
                }

            }
        }

    }

    static class Node {
        public final int x;
        public final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

