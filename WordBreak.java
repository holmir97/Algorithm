// LeetCode_139
// 2021.04.14
// String, List, Dynamic Programming
// Medium

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("car");
        list.add("ca");
        list.add("rs");
        System.out.println(new WordBreak().wordBreak("cars", list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuffer str = new StringBuffer(s);

        // list 길이 오름차순 정렬
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Collections.sort(wordDict, c);
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.contains(word)) {
                while (true) {
                    if (s.indexOf(word) == -1)
                        break;
                    str.replace(s.indexOf(word), s.indexOf(word) + word.length(), "");
                    s = str.toString();
                }
            }
        }
        if (str.length() != 0)
            return false;
        return true;
    }
}

/* USE_DP_출처: LeetCode
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];

    }
}
*/