//num1 + 한글 + space 입력 상태

public class SpaceState implements State {
    LicenseNumber lic;
    public SpaceState(LicenseNumber lic) {
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
        lic.setState(lic.num2State);
        return true;
    }
}
