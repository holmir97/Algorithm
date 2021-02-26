// num1이 입력되어있는 상태

public class Num1State implements State {
    LicenseNumber lic;
    public Num1State(LicenseNumber lic) {
        this.lic = lic;
    }

    @Override
    public boolean processHangul(char ch) {
        if (lic.state == lic.num1State) {
            if (lic.countDigitInNum1 >= 2) { // 기존 입력 숫자가 2개 이상일 때
                lic.licenseNumber += ch;
                lic.setState(lic.hanculState);
            }
            else {
                lic.setState(lic.errorState);
                return false;
            }
        }
        else {
            lic.setState(lic.errorState);
            return false;
        }
        return true;
    }

    @Override
    public boolean processSpace(char ch) {
        lic.setState(lic.errorState);
        return false;
    }

    @Override
    public boolean processDigit(char ch) {
        if (lic.countDigitInNum1 >= 3) { // 이미 입력된 숫자 개수가 3개 이상이면 오류
            lic.setState(lic.errorState);
            return false;
        } else {
            lic.licenseNumber += ch;
            lic.countDigitInNum1++;
            return true;
        }
    }
}
