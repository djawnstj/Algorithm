import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String numStr = sc.next();
        int answer = 0;

        for (int i = 0; i < num; i++) answer += Integer.parseInt(String.valueOf(numStr.toCharArray()[i]));

        System.out.println(answer);

    }
}

