public interface State {
    void printOutResult();
    void processNumber(String ch);
    void processOperator(char ch);
    boolean quit();

}
