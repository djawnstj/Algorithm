
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[] ch;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ch = new int[n + 1];
        arr = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        DFS(arr[1], 1);

        System.out.println(--answer);
    }

    public static void DFS(int[] net, int i) {
        if (ch[i] == 1) return;
        answer++;
        ch[i] = 1;

        for (int j = 0; j < net.length; j++) {
            if (net[j] == 1) DFS(arr[j], j);
        }
    }

}