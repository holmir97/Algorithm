public class MakeLCS {
    public static String[][] makeLCS(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();

        // b[] 화살표 저장 배열 생성
        // c[] 숫자 저장 배열 생성
        String b[][] = new String[s1len][s2len];
        int c[][] = new int[s1len+1][s2len+1];

        // 첫번째 열과 행을 0으로 초기화
        for (int i = 0; i <= s1len; i++)
            c[i][0] = 0;
        for (int j = 0; j <= s2len; j++)
            c[0][j] = 0;

        for (int i = 1; i <= s1len; i++)
            for (int j = 1; j <= s2len; j++) {

                //맨 끝자리 값이 같다면.
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i-1][j-1] = "↖";
                }
                //끝자리 값이 다른 경우.
                else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i-1][j-1] = "↑";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i-1][j-1] = "←";
                }
            }
        // 화살표 배열 b반환
        return b;
    }
}
