
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

//        System.out.println();
//        for (long l : arr) System.out.print(l + " ");
//        System.out.println();
//        System.out.println();

        long result = Long.MAX_VALUE;
        long[] answer = new long[3];

        for (int i = 0; i < n - 2; i++) {
            long x = arr[i];
            for (int j = i + 1; j < n - 1; j++) {
                long y = arr[j];

                long tempSum = x + y;
                long tempSumAbs = Math.abs(tempSum);

                long lp = j + 1;
                long rp = n;

                while (lp <= rp) {
                    int mid = (int) ((lp + rp) / 2);

                    if (lp == rp && rp == n) break;
//                    if (x == -5 && y == 13) {
//                        System.out.println("lp: " + lp + ", rp: " + rp + ", mid: " + mid);
//                    }

                    long cur = arr[mid];
                    long curAbs = Math.abs(cur);
                    long sum = tempSum + cur;
                    long sumAbs = Math.abs(sum);

                    if (result > sumAbs) {

//                        System.out.println("result: " + result + ", sum: " + sum + ", x: " + x + ", y: " + y + ", cur: " + cur);
                        result = sumAbs;
                        answer[0] = x;
                        answer[1] = y;
                        answer[2] = cur;
                    }

                    if (tempSum < 0) {
                        if (cur < 0) lp = mid + 1;
                        else if (tempSumAbs < curAbs) rp = mid - 1;
                        else lp = mid + 1;
                    } else {
                        if (cur > 0) rp = mid - 1;
                        else if (tempSumAbs < curAbs) lp = mid + 1;
                        else rp = mid - 1;
                    }

                }

            }
        }

        Arrays.sort(answer);

        for (long i : answer) System.out.print(i + " ");

    }

}

