public class NumOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }

    // my solution
    public static int maxNumberOfBalloons(String text) {
        StringBuffer str = new StringBuffer(text);
        int len = text.length();
        int i = 0, min = (int)Double.POSITIVE_INFINITY ,idx = 0;
        int[] arr = {0, 0, 0, 0, 0}; //[b, a, l, o, n]

        while (len > 0) {
            if (str.charAt(i) == 'b')
                arr[0] += 1;
            if (str.charAt(i) == 'a')
                arr[1] += 1;
            if (str.charAt(i) == 'l')
                arr[2] += 1;
            if (str.charAt(i) == 'o')
                arr[3] += 1;
            if (str.charAt(i) == 'n')
                arr[4] += 1;
            len--;
            i++;
        }
        arr[0] *= 2;
        arr[1] *= 2;
        arr[4] *= 2;

        for(i = 0; i<arr.length; i++){
            if(min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }

        if(arr[2] == min || arr[3]==min){
            if(arr[idx]%2 == 0)
                return arr[idx]/2;
            else
                return (arr[idx]-1)/2;
        }
        else
            return arr[idx]/2;

    }

    /*
    //best solution
    public static int maxNumberOfBalloons2(String text) {
        int result = 0;
        char count[]=new char[26];
        for(int i=0;i<text.length();i++) count[text.charAt(i)-'a']++;

        String res="balloon";
        while(true){
            for(int i=0;i<res.length();i++) if (count[res.charAt(i) - 'a']— <= 0) return result;
            result++;
        }
    }
     */
}
