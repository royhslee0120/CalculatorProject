package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> history = new ArrayList<>(); // 연산 결과 저장

    public int calculator(int num1, int num2, String op) {

        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("양의 정수(0 포함)를 입력해야합니다. 처음부터 다시 입력해주세요.");
        }

        int result;

        switch (op) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 숫자)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;

            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다. 처음부터 다시 입력해주세요.");
        }

        history.add(result); // 연산 결과 저장

        return result;
    }

    public List<Integer> getHistory() { // Getter 메서드
        return new ArrayList<>(history);
    }

    public void setHistory(List<Integer> history) { // Setter 메서드
        if (history == null) {
            this.history = new ArrayList<>();
        } else {
            this.history = new ArrayList<>(history); // 새로운 리스트로 교체
        }
    }

    public void clearHistory() { // 이력 전체 삭제
        history.clear();
    }
}