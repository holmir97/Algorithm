public class CntSegments {
    public int countSegments(String s) {
        return s.length() == 0? 0: s.split(" ").length;
    }
}

/* best solution
class Solution {
    public int countSegments(String s) {
        int res=0;
        int n = s.length();
        int i=0;
        boolean flag;
        while(i<n){
            flag=false;
            while(i<n && s.charAt(i)!=' '){
                i++;
                flag=true;
            }
             if(flag)
             res++;
            while(i<n && s.charAt(i)==' ')
            {
                i++;
            }

        }
        return res;
    }
}
 */
