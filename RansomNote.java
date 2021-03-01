public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab", "baa"));
    }
    //my solution
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        boolean flag = true;

        for(int i =0; i<ransom.length; i++){
            if( magazine.contains(Character.toString(ransom[i]))){
                for(int j = 0; j<maga.length; j++){
                    if(maga[j] == ransom[i]) {
                        maga[j] = '?';
                        break;
                    }
                }
                magazine = new String(maga);
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}

/*
//best solution
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
              int[] chars = new int[128];
        for (char c : magazine.toCharArray())
            chars[c]++;

        for (char c : ransomNote.toCharArray())
            if (chars[c] > 0) {
                chars[c]--;
            } else
                return false;


        return true;
    }
}
 */
