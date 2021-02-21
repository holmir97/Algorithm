// 두번째 피연산자와 연산자가 들어와 있는 상태

public class SecondOperandState implements State{
    CalcV2_State calc;

    public SecondOperandState(CalcV2_State calc) {
        this.calc = calc;
    }

    @Override
    public void printOutResult() {
        switch (calc.operator) {
            case '+':
                System.out.printf("%d + %d = %d\n", calc.operand1, calc.operand2, calc.operand1 + calc.operand2);
                break;

            case '-':
                System.out.printf("%d - %d = %d\n", calc.operand1, calc.operand2, calc.operand1 - calc.operand2);
                break;

            case '*':
                System.out.printf("%d * %d = %d\n", calc.operand1, calc.operand2, calc.operand1 * calc.operand2);
                break;

            case '/':
                System.out.printf("%d / %d = %d\n", calc.operand1, calc.operand2, calc.operand1 / calc.operand2);
                break;
        }

    }

    @Override
    public void processNumber(String ch) {
        // 다시 숫자가 입력될 경우 피연산자 변경이 일어남, 상태는 그대로.
        calc.operand2 = Integer.parseInt("" + ch);
    }

    @Override
    public void processOperator(char ch) {
        if(ch == '=') {
            calc.printOutResult();
            calc.setState(calc.StartState);
        }else
            System.out.println("연산자를 다시 입력하세요!");
    }

    @Override
    public boolean quit() {
        return false;
    }
}
