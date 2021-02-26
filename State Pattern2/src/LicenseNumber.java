public class LicenseNumber {
    State startState;
    State num1State;
    State hanculState;
    State spaceState;
    State num2State;
    State endState;
    State errorState;

    State state;

    static String licenseNumber = ""; // empty string
    static int countDigitInNum1;
    static int countDigitInNum2;
    static int errorPos;
    
    public LicenseNumber() {
        startState = new StartState(this);
        num1State = new Num1State(this);
        hanculState = new HangulState(this);
        spaceState = new SpaceState(this);
        num2State = new Num2State(this);
        endState = new EndState(this);
        errorState = new ErrorState(this);
        
        // state = startState;
        initialize();
    }
    

    private void initialize() {
        licenseNumber = ""; // empty string
        countDigitInNum1 = 0;
        countDigitInNum2 = 0;
        state = startState;
        errorPos = 0;
    }
    
    // 스테이트 변경 메소드
    void setState(State state){
        this.state = state;
    }

    private boolean processHangul(char ch) { return state.processHangul(ch); }
    private boolean processSpace(char ch) { return state.processSpace(ch); }
    private boolean processDigit(char ch) { return state.processDigit(ch); }



    public int getErrorPos() {
        return errorPos;
    }

    /* verify 함수의 로직 대부분은 수정하지 않아도 됨 */
    public boolean verify(String str) {
        boolean succeeded = true;
        initialize();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                succeeded = processDigit(ch);
            }
            else if (ch == ' ') {
                succeeded = processSpace(ch);
            }
            else if (ch >= '가' && ch <= '힣') { // 입력된 글자가 한글이면
                succeeded = processHangul(ch);
            }
            else { // 다른 글자가 입력되면 오류
                state = errorState;
                errorPos = i;
                return false;
            }
            if (succeeded == false) {
                errorPos = i;
                return false;
            }
        }
        if (state != endState) {  // FSM이 제대로 끝나지 않고 중간에 멈춤
            errorPos = str.length();
            return false;
        }
        return true;
    }
}
