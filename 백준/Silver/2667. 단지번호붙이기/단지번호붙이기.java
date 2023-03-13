
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] ch;
    static int count;
    static List<Integer> answer;

    static int[] dis = {-1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ch = new int[n + 1][n + 1];
        arr = new int[n + 1][n + 1];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char[] s = st.nextToken().toCharArray();

            for (int j = 0; j < n; j++) {
                arr[i+1][j+1] = Integer.parseInt(String.valueOf(s[j]));
            }
        }

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (arr[y][x] == 1 && ch[y][x] ==0) {
                    answer.add(DFS(x, y, n));
                    count++;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(count);
        answer.forEach(it -> System.out.println(it));
    }

    public static int DFS(int x, int y, int n) {
        if (arr[y][x] == 0 || ch[y][x] == 1) return 0;

        int result = 1;

        ch[y][x] = 1;

        for (int distance : dis) {
            int newX = x + distance;
            if (newX > 0 && newX <= n) result += DFS(newX, y, n);
        }
        for (int distance : dis) {
            int newY = y + distance;
            if (newY > 0 && newY <= n) result += DFS(x, newY, n);
        }

        return result;
    }

}