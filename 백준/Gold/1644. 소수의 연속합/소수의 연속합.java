
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if (n < 2) {
            System.out.println(0);
            return;
        }

        isPrime = new boolean[n + 1];

        setPrimeNum(n);

//        List<Integer> primeNum = setPrimeNum(n);

//        int answer = 0;
//        int lp = 0;
//        int sum = primeNum.get(lp);
//
//        for (int rp = 1; rp < primeNum.size() - 1; rp++) {
//            sum += primeNum.get(rp);
//
//            if (sum > n) {
//                while (lp < rp && sum > n) {
//                    sum -= primeNum.get(lp++);
//                }
//            }
//
//            if (sum == n) {
//                answer++;
//            }
//
//        }
//
//        if (isPrime[n]) answer++;

        int answer = 0;
        int rp = 0;
        int sum = 0;

        for (int lp = 0; lp <= n; lp++) {
            while (sum < n && rp < n) {
                if (isPrime[rp]) sum += rp;
                rp++;
            }

            if (sum == n && isPrime[lp]) answer++;
            if (isPrime[lp]) sum -= lp;
        }

        if (isPrime[n]) answer++;
//
        System.out.println(answer);
    }

    public static void setPrimeNum(int num) {

//        List<Integer> primeNum = new ArrayList<>();

        for (int i = 2; i <= num; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= num; i++) {
            if (i > 1000) break;
            else if (!isPrime[i]) continue;
            for (int j = i * i; j <= num; j+=i) {
                isPrime[j] = false;
            }
        }

//        for (int i = 2; i <= num; i++) if (isPrime[i] == 0) primeNum.add(i);

//        return primeNum;
    }

}
