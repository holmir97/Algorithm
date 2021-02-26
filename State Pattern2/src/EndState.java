// 종료 상태

public class EndState implements State {
    LicenseNumber lic;
    public EndState(LicenseNumber lic) {
        this.lic = lic;
    }

    @Override
    public boolean processHangul(char ch) {
        return false;
    }

    @Override
    public boolean processSpace(char ch) {
        return false;
    }

    @Override
    public boolean processDigit(char ch) {
        return false;
    }
}
