
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] ch;
    static int answer;

    static int[] dis = {-1, 1};
    static int[] chDis = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ch = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean check = check(m, n);
        if (!check) DFS(m, n);

        System.out.println(answer);

    }

    public static void DFS(int limitX, int limitY) {

        int[][] newMap = new int[limitY][limitX];

        for (int y = 0; y < limitY; y++) {
            for (int x = 0; x < limitX; x++) {
                newMap[y][x] = arr[y][x];
                if (arr[y][x] > 0) melt(newMap, x, y, limitX, limitY);
            }
        }

        answer++;

        arr = newMap;

//        System.out.println();
//        for (int[] ints : arr) {
//            for (int anInt : ints) System.out.print(anInt + " ");
//            System.out.println();
//        }

        boolean check = check(limitX, limitY);

        if (!check) DFS(limitX, limitY);

    }

    public static void melt(int[][]newMap, int x, int y, int limitX, int limitY) {

        for (int distance : dis) {
            int newX = x + distance;
            if (newX >= 0 && newX < limitX && arr[y][newX] == 0) newMap[y][x] = Math.max(0, newMap[y][x] - 1);
        }

        for (int distance : dis) {
            int newY = y + distance;
            if (newY >= 0 && newY < limitY && arr[newY][x] == 0) newMap[y][x] = Math.max(0, newMap[y][x] - 1);
        }
    }

    public static boolean check(int limitX, int limitY) {
        int result = 0;
        for (int i = 0; i < limitY; i++) {
            for (int j = 0; j < limitX; j++) {
                if (arr[i][j] != 0 && ch[i][j] == 0) {
                    count(j, i, limitX, limitY);
                    result++;
                }
            }
        }

//        System.out.println();
//        for (int[] ints : ch) {
//            for (int anInt : ints) System.out.print(anInt + " ");
//            System.out.println();
//        }
//
//        System.out.println("count: " + result);

        if (result >= 2) return true;
        else if (result == 0) {
            answer = 0;
            return true;
        }

        for (int i = 0; i < limitY; i++) {
            for (int j = 0; j < limitX; j++) {
                if (ch[i][j] == 1) ch[i][j] = 0;
            }
        }

        return false;
    }

    public static void count(int x, int y, int limitX, int limitY) {
        if (ch[y][x] == 1) return;
        else if (arr[y][x] == 0) return;

        ch[y][x] = 1;

        for (int distance : dis) {
            int newX = x + distance;
            if (newX >= 0 && newX < limitX) count(newX, y, limitX, limitY);
        }

        for (int distance : dis) {
            int newY = y + distance;
            if (newY >= 0 && newY < limitY) count(x, newY, limitX, limitY);
        }

//        for (int xDis : chDis) {
//            for (int yDis : chDis) {
//
//                int newX = x + xDis;
//                int newY = y + yDis;
//
//                if ((newX >= 0 && newX < limitX) && (newY >= 0 && newY < limitY)) count(newX, newY, limitX, limitY);
//            }
//        }

    }

}