
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int move = a[0][0];
        if (move < n) {
            DFS(move, 0, a, n);
            if (!arrival) DFS(0, move, a, n);
        }

        if (!arrival) System.out.println("Hing");

    }

    public static boolean arrival = false;
    public static int[][] ch;

    public static void DFS(int curX, int curY, int[][] map, int limit) {
        ch[curX][curY] = 1;

        int move = map[curX][curY];
        int newX = curX + move;
        int newY = curY + move;

        if (!arrival && newX < limit) {
            if (map[newX][curY] == -1) {
                arrival = true;
                System.out.println("HaruHaru");
                return;
            } else if (ch[newX][curY] == 0) DFS(newX, curY, map, limit);
        }

        if (!arrival && newY < limit) {
            if (map[curX][newY] == -1) {
                arrival = true;
                System.out.println("HaruHaru");
                return;
            } else if (ch[curX][newY] == 0) DFS(curX, newY, map, limit);
        }

    }

}
