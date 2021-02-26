public interface State {
    boolean processHangul(char ch);
    boolean processSpace(char ch);
    boolean processDigit(char ch);

}
