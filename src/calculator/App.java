package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 양의 정수(0을 포함)를 입력하세요: ");
        int num1 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
        char op = sc.next().charAt(0);

        System.out.print("두 번째 양의 정수(0을 포함)를 입력하세요: ");
        int num2 = sc.nextInt();

    }
}
