import java.util.*;

// my solution
public class StringMatchingInArray {
    public List<String> stringMatching(String[] words) {
        List<String> lists = new ArrayList<>();
        String[] tmp = words;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (tmp[i].contains(words[j]) && tmp[i] != words[j]) {
                    if (!lists.contains(words[j]))
                        lists.add(words[j]);
                }
            }
        }
        return lists;
    }
}

/* best solution
class Solution {
    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String str : words)
            sb.append(" ").append(str);
        String allstr = sb.toString();

        List<String> result = new LinkedList<>();
        for(String str : words)
            if(allstr.indexOf(str) != allstr.lastIndexOf(str))
                result.add(str);

        return result;
    }
}
 */
