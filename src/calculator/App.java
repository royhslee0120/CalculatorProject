package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("첫 번째 양의 정수(0을 포함)를 입력하세요: ");
            int num1 = sc.nextInt();

            if (num1 < 0) {
                System.out.println("양의 정수(0 포함)를 입력해야합니다."); // 양의 정수(0 포함)를 입력하지 않은 경우 종료
                return;
            }

            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char op = sc.next().charAt(0);

            System.out.print("두 번째 양의 정수(0을 포함)를 입력하세요: ");
            int num2 = sc.nextInt();

            if (num2 < 0) {
                System.out.println("양의 정수(0 포함)를 입력해야합니다."); // 양의 정수(0 포함)를 입력하지 않은 경우 종료
                return;
            }

            int result = 0;

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    // 0으로 나눌수 없도록
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 숫자)에 0이 입력될 수 없습니다.");
                        return;
                    } else {
                        result = num1 / num2;
                        break;
                    }

                default:
                    System.out.println("지원하지 않는 사칙연산 기호입니다."); // 잘못된 사칙연산 기호 입력시 종료
                    return;

            }
            System.out.println("결과: " + result);

        } catch (InputMismatchException e) {
            System.out.println("양의 정수(0 포함)를 입력해주세요."); // 첫번째 숫자, 두번째 숫자에서 정수를 제외한 나머지를 입력한 경우

        }

    }
}
