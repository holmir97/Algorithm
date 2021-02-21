// 첫번째 피연산자와 연산자가 들어와 있는 상태

public class OperatorState implements State {
    CalcV2_State calc;

    public OperatorState(CalcV2_State calc) {
        this.calc = calc;
    }

    @Override
    public void printOutResult() {
        System.out.println("결과를 출력하기에 충분하지 않습니다.");
    }

    @Override
    public void processNumber(String ch) {
        calc.operand2 = Integer.parseInt("" + ch);
        calc.setState(calc.SecondOperandState);
    }

    @Override
    public void processOperator(char ch) {
        System.out.println("숫자를 입력하세요!");
    }

    @Override
    public boolean quit() {
        return false;
    }
}
