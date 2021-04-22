// LeetCode_1669
// 2021.04.22
// Easy

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepeatSubstring {
    public static void main(String[] args) {
        System.out.println(new RepeatSubstring().maxRepeating("ababc","ab"));
    }

    public int maxRepeating(String sequence, String word) {
        List<Integer> list = new ArrayList<>();
        String subSequence = sequence;
        StringBuilder str;
        int cnt = 0;
        int preIdx = word.length();
        int tmp = 0;
        list.add(0);

        while(subSequence.contains(word)) {
            str = checkSubstring(subSequence, word);
            subSequence = str.toString();
            if(preIdx == sequence.indexOf(word)+word.length()) {
                cnt++;
                tmp = cnt;
            }
            else{
                list.add(cnt);
                cnt = 1;
            }

            sequence = subSequence;
        }
        if(list.size() == 1)
            list.add(tmp);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    public static StringBuilder checkSubstring(String str, String word){
        StringBuilder s = new StringBuilder(str);
        String subString ="";

        if(s.indexOf(word) != -1){
            subString = s.substring(s.indexOf(word) + word.length(), s.length());
        }

        return new StringBuilder(subString);
    }
}

/* simple Solution..출처: LeetCode
    public int maxRepeating(String sequence, String word) {


        String w1 = word;
        int res = 0;
        while (w1.length() <= sequence.length()) {
            if (sequence.contains(w1)) {
                res++;
                w1 += word;
            } else {
                break;
            }
        }

        return res;
}
 */
