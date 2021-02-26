// 에러 상태 전부 false 설정

public class ErrorState implements State {
    LicenseNumber lic;
    public ErrorState(LicenseNumber lic) {
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
