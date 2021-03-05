import java.util.HashMap;

public class IsommorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("abdc", "baba"));
    }

    // my solution
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i)) && !hashMap.containsValue(t.charAt(i)))
                hashMap.put(s.charAt(i), t.charAt(i));
            else {
                try {
                    if (hashMap.get(s.charAt(i)) == t.charAt(i))
                        continue;
                    else
                        return false;
                }
                // NullPointerException이 발생했다는 것은 key에 결국 스트링t와 맞는
                // char가 없는 것이므로 무조건 false를 반환한다.
                catch (NullPointerException e){
                    return false;
                }

            }
        }
        return true;
    }
}
