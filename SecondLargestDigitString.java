import java.util.*;


// my solution_USE list
public class SecondLargestDigitString {
    public int secondHighest(String s) {
        StringBuffer str = new StringBuffer(s);
        List<Integer> list = new ArrayList<>();
        char tmp[] = new char[str.length()];

        str.getChars(0,str.length(),tmp,0);

        for (int i = 0; i < str.length(); i++) {
            if (tmp[i] >= '0' && tmp[i] <= '9')
                list.add(tmp[i]-'0');
        }

        List<Integer> resultList = new ArrayList<>();
        list.sort(Comparator.reverseOrder());
        for(int i = 0; i<list.size(); i++){
            if(!resultList.contains(list.get(i)))
                resultList.add(list.get(i));
        }

        if(resultList.size() <2)
            return -1;
        return resultList.get(1);
    }

}

/* best solution_USE TREESET
class Solution {
    public int secondHighest(String s) {
        if (s.length() == 1 || s == null)
            return -1;
        TreeSet < Integer > set = new TreeSet < Integer > ();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                set.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }

        if (set.size() > 1) {
            set.pollLast();
            return set.pollLast();
        } else return -1;

    }
}
 */