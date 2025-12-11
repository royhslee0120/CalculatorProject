package calculator;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    // 문자열 → Enum 변환 메서드
    public static Operator fromString(String input) {
        for (Operator op : Operator.values()) {
            if (op.getSymbol().equals(input)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}

