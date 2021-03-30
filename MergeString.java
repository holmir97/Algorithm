public class MergeString {
    public static void main(String[] args) {
        System.out.println(new MergeString().mergeAlternately("ab", "pqrs"));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuffer str1 = new StringBuffer(word1);
        StringBuffer str2 = new StringBuffer(word2);
        String merge = "";

        while (str1.length() != 0 || str2.length() != 0) {
            if (str1.length() != 0) {
                merge += String.valueOf(str1.charAt(0));
                str1.deleteCharAt(0);
            }
            if (str2.length() != 0) {
                merge += String.valueOf(str2.charAt(0));
                str2.deleteCharAt(0);
            }
        }
        return merge;
    }
}
