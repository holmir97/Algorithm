public class PalindromeNum {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12351235));
        System.out.println(isPalindrome2(12351235));
    }

    // #1 reverse를 이용한 회문 검사 #출처:leetcode
    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;

        int reverse = 0, copy = x;

        while (copy > 0) {
            int digit = copy % 10;
            reverse = reverse * 10 + digit;
            copy /= 10;
        }

        return reverse == x;
    }

    // #2 int배열을 이용한 회문 검사
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x == 0)
            return true;
        int numArr[] = checkNumOFDigit(x);

        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] != numArr[numArr.length - i - 1])
                return false;
        }
        return true;
    }

    public static int[] checkNumOFDigit(int x) {
        int num = (int) (Math.log10(x) + 1);
        int numArr[] = new int[num];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = x % 10;
            x /= 10;
        }
        return numArr;
    }
}
