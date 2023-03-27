
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) test(st, br);

    }

    private static void test(StringTokenizer st, BufferedReader br) throws IOException {
//        System.out.println();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Applicant> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr);

        int answer = 1;
        int maxDocument = arr.get(0).document;

        for (Applicant a : arr) {
//            System.out.println("document: " + a.document + ", interview: " + a.interview);
        }

        for (int i = 1; i < n; i++) {
            if (maxDocument > arr.get(i).document) {
                maxDocument = arr.get(i).document;
                answer++;
            }
        }

        System.out.println(answer);

    }

    static class Applicant implements Comparable<Applicant> {

        final int document;
        final int interview;

        public Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo( Applicant o) {
            return this.interview - o.interview;
        }
    }

}