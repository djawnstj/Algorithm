
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] arr;
    static int[][] ch;
    static int[][] rgCh;
    static int[] answer = new int[4];
    static int[] dis = {-1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ch = new int[n + 1][n + 1];
        rgCh = new int[n + 1][n + 1];
        arr = new char[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char[] s = st.nextToken().toCharArray();

            for (int j = 0; j < n; j++) arr[i + 1][j + 1] = s[j];
        }

        int temp = 0;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (ch[y][x] == 0) {
                    switch (arr[y][x]) {
                        case 'R': {
                            answer[0]++;
                            break;
                        }
                        case 'G': {
                            answer[1]++;
                            break;
                        }
                        case 'B': {
                            answer[2]++;
                            break;
                        }
                    }

                    DFS(arr[y][x], x, y, n);
                }

                if ((arr[y][x] == 'R' || arr[y][x] == 'G') &&rgCh[y][x] == 0) {
                    answer[3]++;
                    colorWeakDFS(x, y, n);
                }
            }
        }

        int total = answer[0] + answer[1] + answer[2];
        int rgSum = answer[2] + answer[3];

        System.out.print(total + " " + rgSum);
    }

    public static void colorWeakDFS(int x, int y, int n) {
        char cur = arr[y][x];

        if (cur == 'B') return;
        else if (rgCh[y][x] == 1) return;

        rgCh[y][x] = 1;

        for (int distance : dis) {
            int newX = x + distance;
            if (newX > 0 && newX <= n) colorWeakDFS(newX, y, n);
        }
        for (int distance : dis) {
            int newY = y + distance;
            if (newY > 0 && newY <= n) colorWeakDFS(x, newY, n);
        }

    }

    public static void DFS(int c, int x, int y, int n) {
        char cur = arr[y][x];

        if (ch[y][x] == 1) return;
        else if (c != cur) return;

        ch[y][x] = 1;

        for (int distance : dis) {
            int newX = x + distance;
            if (newX > 0 && newX <= n) DFS(c, newX, y, n);
        }
        for (int distance : dis) {
            int newY = y + distance;
            if (newY > 0 && newY <= n) DFS(c, x, newY, n);
        }

    }

}