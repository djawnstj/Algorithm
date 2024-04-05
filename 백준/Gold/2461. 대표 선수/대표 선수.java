import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Student[][] school = new Student[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                school[i][j] = new Student(Integer.parseInt(st.nextToken()), i);
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(school[i]);
        }
        int[] pt = new int[N];
        PriorityQueue<Student> pq = new PriorityQueue<>();
        int ans = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (school[i][0].num > max) max = school[i][0].num;
            pq.offer(school[i][0]);
        }

        while (true) {
            Student cur = pq.poll();
            int diff = max - cur.num;
            if (diff < ans) ans = diff;

            if (++pt[cur.classNo] == M) break;

            Student nxt = school[cur.classNo][pt[cur.classNo]];
            pq.offer(school[cur.classNo][pt[cur.classNo]]);
            if (nxt.num > max) max = nxt.num;
        }
        System.out.println(ans);
    }


    static class Student implements Comparable<Student>{
        int num;
        int classNo;

        public Student(int num, int classNo) {
            this.num = num;
            this.classNo = classNo;
        }

        public int compareTo(Student o) {
            return this.num - o.num;
        }
    }
}