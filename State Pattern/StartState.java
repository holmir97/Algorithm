// 맨 처음 초기 상태

public class StartState implements State {
    CalcV2_State calc;

    public StartState(CalcV2_State calc) {
        this.calc = calc;
    }

    @Override
    public void printOutResult() {
        System.out.println("결과를 출력하기에 충분하지 않습니다.");
    }

    @Override
    public void processNumber(String ch) {
        calc.operand1 = Integer.parseInt("" + ch);
        calc.setState(calc.FirstOperandState);
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
