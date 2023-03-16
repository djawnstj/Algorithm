
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] ch;
    static int answer;
    static int[] dis = {-1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ch = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ch[i][j] = -1;
            }
        }

        answer = DFS(0, 0, m, n);

        System.out.println(answer);

    }

    public static int DFS(int x, int y, int limitX, int limitY) {
        if (x == limitX - 1 && y == limitY - 1) return 1;
        else if (ch[y][x] != -1) return ch[y][x];

        ch[y][x] = 0;

        for (int distance : dis) {

            int newX = x + distance;
            if (newX >= 0 && newX < limitX && arr[y][x] > arr[y][newX]) ch[y][x] += DFS(newX, y, limitX, limitY);

            int newY = y + distance;
            if (newY >= 0 && newY < limitY && arr[y][x] > arr[newY][x]) ch[y][x] += DFS(x, newY, limitX, limitY);

        }

        return ch[y][x];
    }

}