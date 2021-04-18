// Leetcode_1347
// 2021.04.18
// Medium

import java.util.HashSet;
import java.util.Iterator;

public class MakeAnagram {
    public static void main(String[] args) {
        System.out.println(new MakeAnagram().minSteps("leetcode","practice"));
    }
    public int minSteps(String s, String t) {
        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(t);
//        HashSet<Character> set = new HashSet<>();

        if(t.length() == 0)
            return 0;
        if(t.length() != s.length())
            return -1;

//        for (int i = 0; i < str1.length(); i++)
//            set.add(str1.charAt(i));

//        Iterator<Character> itr = set.iterator();
        for (int  i= 0; i < str1.length(); i++) {
            char tmp = str1.charAt(i);
            if (t.contains(String.valueOf(tmp))) {
                str2.deleteCharAt(str2.indexOf(String.valueOf(tmp)));
                t = str2.toString();
            }
        }

        HashSet<Character> resultSet = new HashSet<>();
        if(t.length() != 0){
            for (int i = 0; i < t.length(); i++)
                resultSet.add(t.charAt(i));
        }

        return resultSet.size();
    }
}
