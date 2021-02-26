// state 시작

public class StartState implements State {
    LicenseNumber lic;
    public StartState(LicenseNumber lic) {
        this.lic = lic;
    }

    @Override
    public boolean processHangul(char ch) {
        lic.setState(lic.errorState);
        return false;
    }

    @Override
    public boolean processSpace(char ch) {
        lic.setState(lic.errorState);
        return false;
    }


    //num1 이 입력되고 state변경
    @Override
    public boolean processDigit(char ch) {
                lic.licenseNumber += ch;
                lic.countDigitInNum1++; // 글자 개수를 한 개 늘림
                lic.setState(lic.num1State);
        return true;
    }
}
