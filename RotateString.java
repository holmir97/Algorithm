public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("", ""));
    }

    //my solution
    public static boolean rotateString(String A, String B) {
        boolean flag = false;

        if (A.length() != B.length())
            return flag;
        else if (A.length() == 0 && B.length() == 0)
            return true;

        for (int i = 1; i < A.length(); i++) {
            if (A.contains(B.substring(0, i)) && A.contains(B.substring(i, B.length())))
                flag = true;
            else
                continue;
        }
        return flag;
    }
}

//  best solution
/*
class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
 */
