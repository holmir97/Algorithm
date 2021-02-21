// 첫번째 피연산자가 들어와 있는 상태

public class FirstOperandState implements State{
    CalcV2_State calc;

    public FirstOperandState(CalcV2_State calc) {
        this.calc = calc;
    }

    @Override
    public void printOutResult() {
        System.out.println("결과를 출력하기에 충분하지 않습니다.");
    }

    @Override
    public void processNumber(String ch) {
        // 다시 숫자가 입력될 경우 피연산자 변경이 일어남, 상태는 그대로.
        calc.operand1 = Integer.parseInt("" + ch);
    }

    @Override
    public void processOperator(char ch) {
        calc.operator = ch;
        calc.setState(calc.OperatorState);
    }

    @Override
    public boolean quit() {
        return false;
    }
}
