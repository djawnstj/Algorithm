
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n;
    static int m;
    static int[] disX = new int[]{1, 0, -1, 0};
    static int[] disY = new int[]{0, 1, 0, -1};
    static List<Point> cheese = new ArrayList<>();
    static Queue<Point> melt = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) cheese.add(new Point(j, i));
            }
        }

        arr[0][0] = 2;
        check(new Point(0, 0));

        int answer = 0;

        while (!cheese.isEmpty()) {
            checkMelt();
            answer++;
        }

        System.out.println(answer);
    }

    static void check(Point point) {

        Queue<Point> air = new LinkedList<>();
        air.offer(point);

        while (!air.isEmpty()) {
            Point cur = air.poll();

            for (int i = 0; i < 4; i++) {
                int newX = disX[i] + cur.x;
                int newY = disY[i] + cur.y;

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;

                if (arr[newY][newX] == 0) {
                    arr[newY][newX] = 2;
                    air.offer(new Point(newX, newY));
                }
            }
        }

    }

    static void checkMelt() {

        for (Point p : cheese) {
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int newX = disX[i] + p.x;
                int newY = disY[i] + p.y;

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;

                if (arr[newY][newX] == 2) cnt++;
                if (cnt == 2) break;
            }

            if (cnt == 2) melt.offer(p);

        }

        melt();

    }

    static void melt() {
        while (!melt.isEmpty()) {
            Point p = melt.poll();
            arr[p.y][p.x] = 2;
            check(p);
            cheese.remove(p);
        }
    }

    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

