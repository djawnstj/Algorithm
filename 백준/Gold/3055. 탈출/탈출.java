
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] arr;
    static boolean[] ch;
    static int n;
    static int m;
    static int beaverX;
    static int beaverY;
    static int[] disX = new int[]{1, 0, -1, 0};
    static int[] disY = new int[]{0, 1, 0, -1};
    static Queue<WaterPoint> water;
    static Queue<Point> points;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        water = new LinkedList<>();
        points = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] s = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s[j];
                if (s[j] == 'D') {
                    beaverX = j;
                    beaverY = i;
                } else if (s[j] == 'S') points.offer(new Point(j, i, 0));
                else if (s[j] == '*') water.offer(new WaterPoint(j, i));

            }
        }

        bfs();
        System.out.println((answer == Integer.MAX_VALUE) ? "KAKTUS" : answer);

    }

    static void bfs() {
        while (!points.isEmpty()) {
            int len = water.size();

            // 물 먼저 퍼트리기
            for (int i = 0; i < len; i++) {
                WaterPoint cur = water.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = cur.x + disX[j];
                    int newY = cur.y + disY[j];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && arr[newY][newX] == '.') {
                        arr[newY][newX] = '*';
                        water.offer(new WaterPoint(newX, newY));
                    }
                }
            }

            len = points.size();

            for (int i = 0; i < len; i++) {
                Point cur = points.poll();

                for (int j = 0; j < 4; j++) {
                    int newX = cur.x + disX[j];
                    int newY = cur.y + disY[j];
                    if (!(newX >= 0 && newX < m && newY >= 0 && newY < n)) continue;
                    if (arr[newY][newX] == 'D') {
                        answer = Math.min(answer, cur.time + 1);
                    } else if (arr[newY][newX] == '.') {
                        arr[newY][newX] = 'S';
                        points.offer(new Point(newX, newY, cur.time + 1));
                    }
                }

            }

        }
    }

    static class WaterPoint {
        final int x;
        final int y;

        public WaterPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point {
        final int x;
        final int y;
        final int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}

