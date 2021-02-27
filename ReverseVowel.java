public class ReverseVowel {
    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    //my solution
    public static String reverseVowels(String s) {
        StringBuffer str = new StringBuffer(s);
        int len = str.length() - 1;
        int i = 0;

        while (true) {
            while (len > i) {
                if (checkVowels(str.charAt(i)) && checkVowels(str.charAt(len)))
                    break;
                if (!checkVowels(str.charAt(i)))
                    i++;
                if (!checkVowels(str.charAt(len)))
                    len--;

            }
            if (len <= i)
                break;
            if (str.charAt(i) == str.charAt(len)) {
                i++;
                len--;
                continue;
            }
            String tmp = Character.toString(str.charAt(len));
            str.replace(len, len + 1, Character.toString(str.charAt(i)));
            str.replace(i, i + 1, tmp);
            i++;
            len--;
        }

        return str.toString();
    }

    public static boolean checkVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }
}

//best solution
/*class Solution {
    public String reverseVowels(String s) {
        boolean[] v = new boolean[256];
        v['a']=true;
        v['e']=true;
        v['i']=true;
        v['o']=true;
        v['u']=true;
        v['A']=true;
        v['E']=true;
        v['I']=true;
        v['O']=true;
        v['U']=true;
        char[] c = s.toCharArray();
        char r;
        int i=0,j=s.length()-1;
        while(j>i){
            if(v[c[i]] && v[c[j]]){
                r = c[j];
                c[j] = c[i];
                c[i] = r;
                i++;j--;
            }
            else if(v[c[i]]) j--;
            else i++;
        }
        return new String(c);
    }
}*/
