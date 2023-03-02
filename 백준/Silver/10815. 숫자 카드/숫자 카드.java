
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());

        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());


        Arrays.sort(a);

        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int find = b[i];

            int lt = 0;
            int rt = n - 1;

            // -10 2 3 6 10

            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                int found = a[mid];
                if (found == find) {
                    answer[i] = 1;
                    break;
                }
                else if (found > find) rt = mid - 1;
                else lt = mid + 1;
            }

        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

}
