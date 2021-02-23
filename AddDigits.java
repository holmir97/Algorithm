public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    //my solution
    public static int addDigits(int num) {
        int sum = 0;
        if (num / 10 == 0)
            return num;

        while (true) {
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
            if (sum / 10 == 0)
                break;
            sum = 0;
        }
        return sum;
    }

    class Solution {
        public int addDigits(int num) {

            while (digSum(num) > 9) {
                num = digSum(num);
            }
            return digSum(num);
        }

        public int digSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum = sum + n % 10;
                n = n / 10;
            }
            return sum;
        }
    }

    // best solution
    public int addDigits-bs(int num) {

        while (digSum(num) > 9) {
            num = digSum(num);
        }
        return digSum(num);
    }

    public int digSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

}
