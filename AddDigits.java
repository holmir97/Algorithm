public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits_bs(38));
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

    // best solution
    public static int addDigits_bs(int num) {

        while (digSum(num) > 9) {
            num = digSum(num);
        }
        return digSum(num);
    }

    public static int digSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

}
