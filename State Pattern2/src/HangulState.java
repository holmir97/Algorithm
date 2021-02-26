// num1+ 한글 입력 상태


public class HangulState implements State {
    LicenseNumber lic;
    public HangulState(LicenseNumber lic) {
        this.lic = lic;
    }

    @Override
    public boolean processHangul(char ch) {
        lic.setState(lic.errorState);
        return false;
    }

    @Override
    public boolean processSpace(char ch) {
        lic.licenseNumber += ch;
        if (lic.state == lic.hanculState) {
            lic.licenseNumber += ch;
            lic.setState(lic.spaceState);
        }
        else {
            lic.setState(lic.errorState);
            return false;
        }
        return true;
    }

    @Override
    public boolean processDigit(char ch) {
        lic.setState(lic.errorState);
        return false;
    }
}
