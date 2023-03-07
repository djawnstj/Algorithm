
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

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 이분탐색을 끝내고 나온 결과값의 절대값을 0과 빼서 그 차가 가장 적은 수를 result와 비교
        int[] answer = new int[2];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) break;

            int lp = i + 1;
            int rp = n - 1;

//            System.out.println("======================================");
//            System.out.println("i : " + i + ", " + arr[i]);
//            System.out.println("======================================");

            while (lp <= rp) {
                int mid = (lp + rp) / 2;

                int temp = Math.abs(arr[i] + arr[mid]);
//                System.out.println("before - mid: " + mid + ", lp: " + lp + ", rp: " + rp + ", l: " + arr[i] + ", r: " + arr[mid] + ", result: " + result + ", temp: " + temp);

                boolean check = Math.abs(arr[i]) <= Math.abs(arr[mid]);
                if (temp < result) {
                    result = temp;
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                    if (check) rp = mid - 1;
                    else lp = mid + 1;
                } else {    
                    if (check) rp = mid - 1;
                    else lp = mid + 1;
                }

                if (result == 0) {
                    Arrays.sort(answer);

                    for (int i1 : answer) System.out.print(i1 + " ");
                    return;
                }

//                System.out.println("after - lp: " + lp + ", rp: " + rp + ", l: " + arr[i] + ", r: " + arr[mid] + ", result: " + result + ", temp: " + temp);
            }
//            System.out.println("======================================");
//            System.out.print("answer:");
//            for (int i1 : answer) System.out.print(" " + i1);
//            System.out.println();
//            System.out.println("======================================");
//            System.out.println();

        }

/*
5
-99 -2 -1 4 98
-98 99

9
-1000000 -99 99 100 101 102 103 104 105
-99 99

4
-100 -2 -1 103
-100 103 (-2 -1)

4
-400 -390 389 398
-390 389

4
-140 0 100 200
-140 100

4
-3 -2 -1 2
-2 2

 */

        Arrays.sort(answer);

        for (int i : answer) System.out.print(i + " ");

    }

}
