
// my solution_USE_BubbleSort
public class ShuffleString {
    public static void main(String[] args) {
        System.out.println(new ShuffleString().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
    public String restoreString(String s, int[] indices) {
        StringBuffer stringBuffer = new StringBuffer(s);
        int temp = 0;
        char tempS;

        for (int i = 0; i < indices.length-1; i++) {
            for (int j = 0; j < indices.length -1 - i; j++) {
                if (indices[j] > indices[j + 1]) {
                    temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;

                    tempS = stringBuffer.charAt(j);
                    stringBuffer.replace(j, j+1, String.valueOf(stringBuffer.charAt(j+1)));
                    stringBuffer.replace(j+1, j+2, String.valueOf(tempS));
                }
            }
        }
        return stringBuffer.toString();
    }
}


/* best solution
class Solution {
    public String restoreString(String s, int[] indices)
    {
        char[] str = new char[indices.length];
        for (int i = 0; i<indices.length ; i++)
        {
            str[indices[i]] = s.charAt(i);
        }
        return String.valueOf(str);
    }
}
*/

