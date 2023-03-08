
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dishes;
    static int count = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        dishes = new int[d + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 시작부터 마지막까지 차례대로 초밥을 먹는 경우
        for (int i = 0; i < k; i++) {
            int dish = arr[i];
            if (dishes[dish] == 0) count++;
            dishes[dish]++;
        }

        if (dishes[c] == 0) {
            count++;
            answer = count;
            count--;
        } else answer = count;

        for (int lp = 0; lp < n - k ; lp++) {
            int rp = lp + k;
            int addDish = arr[rp];
            int removeDish = arr[lp];

            dishes[removeDish]--;
            if (dishes[removeDish] == 0) count--;

            if (dishes[addDish] == 0) count++;
            dishes[addDish]++;

            if (dishes[c] == 0) {
                count++;
                answer = Math.max(answer, count);
                count--;
            } else answer = Math.max(answer, count);
        }

        // 마지막과 시작 부분을 이어서 초밥을 먹는 경우
        for (int lp = n - k; lp < (n - k) + k - 1; lp++) {
            int rp = lp + k;
            if (rp >= n) rp -= n;

            int addDish = arr[rp];
            int removeDish = arr[lp];

            dishes[removeDish]--;
            if (dishes[removeDish] == 0) count--;

            if (dishes[addDish] == 0) count++;
            dishes[addDish]++;


            if (dishes[c] == 0) {
                count++;
                answer = Math.max(answer, count);
                count--;
            } else answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

}
