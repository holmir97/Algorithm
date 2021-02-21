//State 패턴을 적용한 코드

import java.util.Scanner;

public class CalcV2_State {
    State StartState;
    State FirstOperandState;
    State OperatorState;
    State SecondOperandState;

    State state;

    Scanner scanner;
    String inputStr;
    int operand1; // 첫 번째 피 연산자값 저장
    int operand2; // 두 번째 피 연산자값 저장
    char operator; // 사칙 연산자 저장

    CalcV2_State() {
        scanner = new Scanner(System.in);

        StartState = new StartState(this);
        FirstOperandState = new FirstOperandState(this);
        OperatorState = new OperatorState(this);
        SecondOperandState = new SecondOperandState(this);

        state = StartState;
    }


    void printOutResult(){
        state.printOutResult();
    }
    void processNumber(String ch){
        state.processNumber(ch);
    }
    void processOperator(char ch){
        state.processOperator(ch);
    }
    boolean quit(){
        return state.quit();
    }

    void setState(State state){
        this.state= state;
    }

    String getInput(String s) {
        System.out.println(s);
        return scanner.next();
    }


    boolean run() {
        inputStr = getInput("정수 또는 +,-,*,/,= 기호 중 한 개를 입력하세요");
        char ch = inputStr.charAt(0);
        if (ch == 'q' || ch == 'Q') { // q를 입력하면 프로그램 종료
            return quit();
        }
        else if (ch >= '0' && ch <= '9') {
            processNumber(inputStr);
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') {
            processOperator(ch);
        }
        return true;
    }
}
