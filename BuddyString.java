public class BuddyString {
    public static void main(String[] args) {
        System.out.println(new BuddyString().buddyStrings("aaaaaaabc","aaaaaaacb"));
    }
    public boolean buddyStrings(String a, String b) {
        StringBuffer str1 = new StringBuffer(a);
        StringBuffer str2 = new StringBuffer(b);
        boolean flag = false;

        int len = str1.length()>str2.length()? str1.length():str2.length();
//        if(a.equals(b))
//            return true;

        for(int i = 0; i<len-1; i++){
            try {
                char tmp = ' ';
                tmp = str2.charAt(i);
                str2.replace(i,i+1,String.valueOf(str2.charAt(i+1)));
                str2.replace(i+1,i+2,String.valueOf(tmp));

                if(str1.toString().equals(str2.toString()))
                    return flag = true;
                else {
                    tmp = str2.charAt(i);
                    str2.replace(i,i+1,String.valueOf(str2.charAt(i+1)));
                    str2.replace(i+1,i+2,String.valueOf(tmp));
                }

            }catch (IndexOutOfBoundsException e){
                return false;
            }
        }
        return flag;
    }
}

/* O(N) 출처: LeetCode
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }
}
 */
