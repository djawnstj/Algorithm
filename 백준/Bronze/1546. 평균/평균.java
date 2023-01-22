import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        double[] numArr = new double[num];

        double maxVal = 0.0;
        double sum = 0.0;

        for (int i = 0; i < num; i++) {
            double temp = sc.nextInt();
            numArr[i] = temp;
            maxVal = Math.max(maxVal, temp);
        }

        for (double v : numArr) {
            sum += v / maxVal * 100;
        }

        System.out.println(sum/num);

    }
}

