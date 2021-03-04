public class PowerOfTwo {

    // 반복문 사용
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n > 1) {
            if (n % 2 == 1)
                return false;
            n /= 2;
        }
        return true;
    }

    /*
    // 재귀 사용
    public boolean isPowerOfTwo(int n) {

        if(n==1) return true ;
        else if ( n%2==1 || n==0 ) return false ;

        return isPowerOfTwo(n/2);

    }
    */
}
