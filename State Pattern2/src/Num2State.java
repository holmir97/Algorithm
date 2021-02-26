//num1 + 한글 + space + num2 입력상태

public class Num2State implements State {
    LicenseNumber lic;
    public Num2State(LicenseNumber lic) {
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

    @Override
    public boolean processDigit(char ch) {
        lic.licenseNumber += ch;
        lic.countDigitInNum2++;
        if (lic.countDigitInNum2 == 4) {
            lic.setState(lic.endState);;
        }
        return true;
    }
}
