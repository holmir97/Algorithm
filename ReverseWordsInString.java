//LeetCode_151
//2021.04.15
//Medium

import java.util.ArrayList;
import java.util.List;

// my solution
public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        char[] word = s.toCharArray();
        List<Character> list = new ArrayList<>();
        char pre = ' ';

        for (int i = 0; i < word.length; i++) {
            if (i == 0) {
                list.add(word[i]);
                pre = list.get(i);
                continue;
            }
            if (pre == ' ' && word[i] == ' ')
                continue;
            list.add(word[i]);
            pre = list.get(list.size()-1);
        }

        String strWord = "";
        for (int i = 0; i < list.size(); i++)
            strWord += list.get(i);

        String[] str = strWord.split(" ");
        for(int i = 0; i<str.length/2; i++){
            String temp;
            temp = str[i];
            str[i] = str[str.length-i-1];
            str[str.length-1-i] = temp;
        }
        String answer = String.join(" ", str).trim();

        return answer;
    }
}

/* USE_투포인터_출처:Leetcode
public class Solution {

  public String reverseWords(String s) {
    if (s == null) return null;

    char[] a = s.toCharArray();
    int n = a.length;

    // step 1. reverse the whole string
    reverse(a, 0, n - 1);
    // step 2. reverse each word
    reverseWords(a, n);
    // step 3. clean up spaces
    return cleanSpaces(a, n);
  }

  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;

    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1);                      // reverse the word
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;

    while (j < n) {
      while (j < n && a[j] == ' ') j++;             // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++;             // skip spaces
      if (j < n) a[i++] = ' ';                      // keep only one space
    }

    return new String(a).substring(0, i);
  }

  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int i, int j) {
    while (i < j) {
      char t = a[i];
      a[i++] = a[j];
      a[j--] = t;
    }
  }

}
 */