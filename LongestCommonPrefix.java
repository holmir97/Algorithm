// LeetCode_14
// 2021.04.19
// Easy

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        StringBuilder str = new StringBuilder(strs[0]);
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            list.clear();
            int len = str.length();
            String tmp = "";

            if (str.length() > strs[i].length())
                len = strs[i].length();

            if (str.toString().equals(strs[i]))
                continue;
            else {
                for (int j = 0; j < len; j++) {
                    if (str.charAt(j) == strs[i].charAt(j))
                        list.add(str.charAt(j));
                    else
                        break;
                }

                for (int j = 0; j < list.size(); j++)
                    tmp += String.valueOf(list.get(j));
                str = new StringBuilder(tmp);
                tmp = "";
            }
        }
        return str.toString();
    }
}

/* USE_binarySearch 출처: LeetCode
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}
 */