package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator<Double> calculator = new Calculator<>(); // Calculator 객체 생성

        while(true) { // 계산기 반복을 위한 while문

            try {
                System.out.print("첫 번째 양의 정수(0을 포함)를 입력하세요: ");
                double num1 = sc.nextInt();

//                if (num1 < 0) { // 실수를 받기로 했으므로 주석처리
//                    System.out.println("양의 정수(0 포함)를 입력해야합니다. 처음부터 다시 입력해주세요."); // 양의 정수(0 포함)를 입력하지 않은 경우 바로 재시작 시키기 위해서 문구 수정
//                    continue; // exit을 입력하기 전까지는 반복하도록 return에서 continue로 수정
//                }

                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                String opInput = sc.next(); // char 사용시 ++도 정상 연산자로 인식 / char는 첫글자만 읽기 때문에 그 이후에 다른 문자가 와도 정상으로 인식 따라서 string으로 변경

                Operator operator = Operator.fromString(opInput);

//                if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) { // char -> string으로 변경했으므로 != 가 아닌 equals문으로 변경
//                    System.out.println("지원하지 않는 연산자입니다. 처음부터 다시 입력해주세요."); // 연산자 잘 못 입력시 바로 재시작 시키기 위해서 switch문에서 default문 삭제하고 if문 추가
//                    continue;
//                }  // enum 사용시 필요없는 코드

                System.out.print("두 번째 양의 정수(0을 포함)를 입력하세요: ");
                double num2 = sc.nextInt();

//                if (num2 < 0) { // 실수를 받기로 했으므로 주석처리
//                    System.out.println("양의 정수(0 포함)를 입력해야합니다. 처음부터 다시 입력해주세요."); // 양의 정수(0 포함)를 입력하지 않은 경우 바로 재시작 시키기 위해서 문구 수정
//                    continue; // exit을 입력하기 전까지는 반복하도록 return에서 continue로 수정
//                }

                double result = calculator.calculator(num1, num2, operator); // 계산은 Calculator 클래스가

                System.out.println("결과: " + result);

                System.out.println("현재까지의 연산 결과 이력: " + calculator.getHistory()); // 현재까지의 연산 기록 출력

                System.out.print("계산 이력을 삭제하시겠습니까?(all 입력 시 전체 삭제, first 입력 시 가장 먼저 저장된 이력 삭제): "); // 전체와 먼저 저장된 데이터 입력시를 구분하기 위해서 all과 first로 구분
                String reset = sc.next();

                if (reset.equalsIgnoreCase("all")) {
                    calculator.setHistory(new ArrayList<>()); // 빈 리스트를 새로 만들어서 Setter로 전달
                    System.out.println("계산 이력을 모두 삭제했습니다.");
                    System.out.println(calculator.getHistory()); // 계산 이력이 비어있는것을 확인 시켜줌

                }  else if (reset.equalsIgnoreCase("first")) {     // 첫 번째 이력만 삭제
                    calculator.removeHistory();                   // 이력 비어 있으면 그냥 아무 일도 안 함
                    System.out.println(calculator.getHistory()); // 삭제된 이후 계산 이력 출력
                }

                String answer;

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                answer = sc.next();

                if (answer.equalsIgnoreCase("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    return;
                }

            } catch (InputMismatchException e) {
                System.out.println("양의 정수(0 포함)를 입력해야합니다. 처음부터 다시 입력해주세요."); // 첫번째 숫자, 두번째 숫자에서 정수를 제외한 나머지를 입력한 경우
                sc.nextLine(); // 잘못된 입력 제거

            } catch (IllegalArgumentException e) { // 음수 입력, 지원하지 않는 연산자 등 Calculator에서 던진 예외 처리
                System.out.println(e.getMessage());

            } catch (ArithmeticException e) { // 0으로 나누기 등 Arithmetic 관련 예외 처리
                System.out.println(e.getMessage());
            }

        }

    }
}
