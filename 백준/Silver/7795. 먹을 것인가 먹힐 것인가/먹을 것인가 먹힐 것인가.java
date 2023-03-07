
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = initSt(br);

        int t = getInt(st);

        for (int i = 0; i < t; i++) {

            st = initSt(br);

            int n = getInt(st);
            int m = getInt(st);

            int[] a = new int[n];
            int[] b = new int[m];

            st = initSt(br);
            for (int j = 0; j < n; j++) a[j] = getInt(st);
            st = initSt(br);
            for (int j = 0; j < m; j++) b[j] = getInt(st);

            Arrays.sort(a);
            Arrays.sort(b);

            int answer = 0;

            int rp = 0;

            for (int lp = 0; lp < n; lp++) {

                if (rp >= m) break;

                int aTemp = a[lp];
                int bTemp = b[rp];
                int win = 0;

                while (aTemp > bTemp) {
                    win++;
                    if (rp >= m-1) {
                        ++rp;
                        break;
                    }
                    bTemp = b[++rp];
                }

                 if (win > 0 ) answer += (n - lp) * win;
            }

            System.out.println(answer);
        }
    }

    public static StringTokenizer initSt(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    public static int getInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

}
