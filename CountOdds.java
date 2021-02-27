public class CountOdds {
    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
    }

    //my solution
    public static int countOdds(int low, int high) {
        if (low % 2 == 1 || high % 2 == 1)
            return (high - low) / 2 + 1;
        return (high - low) / 2;
    }
}

//best solution
class Solution {
    public int countOdds(int low, int high) {
        if (low == 0 && high == 0) return 0;
        int n = high - low + 1;
        if (n % 2 == 0) return n/2;
        if (high % 2 == 0) return n/2;
        return n/2 + 1;
    }
}