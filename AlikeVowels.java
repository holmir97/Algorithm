public class AlikeVowels {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("eeeddd"));
    }

    public static boolean checkVowels(String c) {
        if (c.contains("a") || c.contains("e") || c.contains("i") || c.contains("o") || c.contains("u"))
            return true;
        else
            return false;
    }

    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int cntA = 0;
        int cntB = 0;
        int j;

        String[] strArr = s.split("");
        if (strArr.length % 2 == 1)
            j = strArr.length / 2 + 1;
        else
            j = strArr.length / 2;


        for (int i = 0; i < strArr.length / 2; i++, j++) {
            if (checkVowels(strArr[i]))
                cntA++;
            if (checkVowels(strArr[j]))
                cntB++;
        }

        if (cntA == cntB)
            return true;
        else
            return false;
    }
}
