import java.util.HashMap;

// my solution_O(n)
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hashMap = new HashMap<>();
        StringBuffer strPattern = new StringBuffer(pattern);
        String[] str = s.split(" ");

        if(str.length != strPattern.length())
            return false;

        for(int i = 0; i<str.length; i++){
            if(!hashMap.containsKey(strPattern.charAt(i))) {
                if(hashMap.containsValue(str[i]))
                    return false;
                hashMap.put(strPattern.charAt(i), str[i]);
            }
            else {
                if(!hashMap.get(strPattern.charAt(i)).equals(str[i]))
                    return false;
            }
        }
        return true;
    }
}
