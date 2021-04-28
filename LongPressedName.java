// LeetCode_925
// 2021.04.28
// Easy

import java.util.Stack;

public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("saeed", "ssaaedd"));
    }
    public boolean isLongPressedName(String name, String typed) {
        StringBuilder str = new StringBuilder(name);
        StringBuilder typ = new StringBuilder(typed);
        int strIdx = 0, typIdx = 0;
        boolean flag = true;

        Stack<Character> stk = new Stack<>();

        while(typIdx != typed.length()){
            if(stk.empty()) {
                stk.push(str.charAt(strIdx));
                strIdx++;
            }

            if(typ.charAt(typIdx) == stk.peek()){
                typIdx++;
            }else {
                try {
                    stk.push(str.charAt(strIdx));
                    strIdx++;

                    if(typ.charAt(typIdx) == stk.peek()){
                        typIdx++;
                    }else {
                        flag = false;
                        break;
                    }
                }catch (IndexOutOfBoundsException e){
                    break;
                }

            }
        }
        return flag;
    }


}

/* USE_TWOPointer 출처: leetcode
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int np = 0, tp = 0;
        char[] name_chars = name.toCharArray();
        char[] typed_chars = typed.toCharArray();


        while (np < name_chars.length && tp < typed_chars.length) {
            if (name_chars[np] == typed_chars[tp]) {
                np += 1;
                tp += 1;
            } else if (tp >= 1 && typed_chars[tp] == typed_chars[tp - 1]) {
                tp += 1;
            } else {
                return false;
            }
        }

        if (np != name_chars.length) {
            return false;
        } else {

            while (tp < typed_chars.length) {
                if (typed_chars[tp] != typed_chars[tp - 1])
                    return false;
                tp += 1;
            }
        }

        return true;
    }
}
 */