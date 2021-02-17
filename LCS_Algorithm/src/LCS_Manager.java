public class LCS_Manager {
    public static void main(String args[]) {
        String s1, s2;
        String[][] b;

        // 랜덤 INPUT DNA S1, S2 생성
        s1 = InputLCS.makeString();
        s2 = InputLCS.makeString();

        // INPUT DNA
        System.out.println("------------------INPUT_DNA------------------");
        System.out.println("DNA(S1): " + s1);
        System.out.println("DNA(S2): " + s2);

        // MACK LCS
        b = MakeLCS.makeLCS(s1, s2);    // 화살표 배열(b) 반환

        // OUTPUT DNA
        System.out.println("\n\n-----------------OUTPUT_DNA------------------");
        PrintLCS.printLCS(b, s1, s1.length(), s2.length());// PRINT LCS DNA

        // PRINT 화살표 배열
        System.out.println("\n\n\n-----------프로그램에 사용된 화살표 배열(b)-----------");
        PrintLCS.printArr(b,s1,s2);
    }
}
