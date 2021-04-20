// LeetCode_890
// 2021.04.20
// Medium
// HashMap,HashSet

import java.util.*;

public class ReplacePattern {
    public static void main(String[] args) {
        System.out.println(
                new ReplacePattern().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> patternSet = new HashSet<>();
        boolean flag;

        for(char c : pattern.toCharArray())
            patternSet.add(c);

        for(int i = 0; i<words.length; i++){
            flag = true;
            for(int j = 0; j<words[i].length(); j++) {
                char w = words[i].charAt(j);
                char p = pattern.charAt(j);

                if (!map.containsKey(p))
                    map.put(p,w);
                else {
                    if (!map.get(p).equals(w))
                        flag = false;
                }
            }
            HashSet<Character> wordSet = new HashSet<>(map.values());
            if(wordSet.size() != patternSet.size())
                flag = false;
            if(flag)
                list.add(words[i]);
            map.clear();
        }
        return list;
    }
}

/* USE_Two hashmap_출처: leetcode
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            if (m1.get(w) != p || m2.get(p) != w)
                return false;
        }

        return true;
    }
}
 */
