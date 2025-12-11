package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator<T extends Number> {

    private List<Double> history = new ArrayList<>(); // 연산 결과 저장

    public double calculator(T num1, T num2, Operator op) { // 어떤 실수를 받아도 가능하려면 double로 변경

        double a = num1.doubleValue();
        double b = num2.doubleValue();

//        if (num1 < 0 || num2 < 0) { // 실수를 받기로 했으므로 주석처리
//            throw new IllegalArgumentException("양의 정수(0 포함)를 입력해야합니다. 처음부터 다시 입력해주세요.");
//        }

        double result;

        switch (op) {
            case PLUS:
                result = a + b;
                break;

            case MINUS:
                result = a - b;
                break;

            case MULTIPLY:
                result = a * b;
                break;

            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 숫자)에 0이 입력될 수 없습니다.");
                }
                result = a / b;
                break;

            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다. 처음부터 다시 입력해주세요.");
        }

        history.add(result); // 연산 결과 저장

        return result;
    }

    public List<Double> getHistory() { // Getter 메서드
        return new ArrayList<>(history);
    }

    public void setHistory(List<Double> history) { // Setter 메서드
        if (history == null) {
            this.history = new ArrayList<>();
        } else {
            this.history = new ArrayList<>(history); // 새로운 리스트로 교체
        }
    }

//    public void clearHistory() { // 이력 전체 삭제 (사용되지 않는 코드 주석 처리)
//        history.clear();
//    }

    public void removeHistory() {
        if (history.isEmpty()) {
            return; // 삭제할 이력이 없을 때
        }
        history.remove(0); // 첫 번째 요소 제거
    }

    public List<Double> findResults(double target) { // Lambda & Stream을 사용해서 history에서 조건에 맞는 값만 필터링
        return history.stream()               // List<Double> → Stream<Double>
                .filter(result -> result > target) // target 보다 큰 값만 통과
                .collect(Collectors.toList());     // 다시 List<Double>로 수집
    }
}