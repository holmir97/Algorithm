// LeetCode_1805
// 2021.04.21
// Easy


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class alphanumeric {
    public static void main(String[] args) {
//        System.out.println(new alphanumeric().numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(new alphanumeric().numDifferentIntegers("167278959591294"));
    }
    public int numDifferentIntegers(String word) {
        StringBuilder s = new StringBuilder(word);
        List<Integer> list = new ArrayList<>();
        List<String> sublist = new ArrayList<>();
        HashSet<List> set1,set2;
        String tmp ="";
        int len = s.length();

        for(int i = 0; i<s.length(); i++){
            if(i == len-1)
                s.append("e");
            if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
                tmp += s.charAt(i);
            else
                if(!tmp.equals("")) {
//                    if(word.substring(0,i-tmp.length()).contains(tmp))
//                        continue;
                    try {
                        list.add(Integer.valueOf(tmp));
                    }catch (NumberFormatException e){
                        sublist.add(tmp);
                    }
                    tmp ="";
                }
        }

        set1 = new HashSet(list);
        set2 = new HashSet(sublist);
        return set1.size()+ set2.size();
    }
}

/*  SimpleSolution_출처: leetcode
class Solution {
    public int numDifferentIntegers(String word) {
        String[] arr = word.replaceAll("[a-zA-Z]", " ").split("\\s+");
        Set<String> set = new HashSet<String>();

        for (String str : arr) {
            if (!str.isEmpty())
                set.add(String.valueOf(str.replaceAll("^0*","")));
        }

        return set.size();
    }
}
 */

