public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    //my solution
    public static boolean isPalindrome(String s) {
        StringBuffer str = makeStringArr(s);
        if (str.length() <= 1 || s.equals(" ")) return true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    public static StringBuffer makeStringArr(String s) {
        s = s.toLowerCase().replace(" ", "");
        StringBuffer str = new StringBuffer(s);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97 || str.charAt(i) > 122) {
                if(str.charAt(i)>=48 && str.charAt(i) <=57)
                    continue;
                else {
                    str.deleteCharAt(i);
                    i--;
                }
            }
        }
        System.out.println(str);
        return str;
    }

    // best solution
    public boolean isPalindrome_bs(String s) {
        int left = 0, right = s.length()-1;
        while(left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
