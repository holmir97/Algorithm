import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;


/*      // O(n^2)
        boolean flag;
        int result = nums[0];

        for(int i = 0; i<nums.length;i++){
            flag = false;
            for(int j = i; j< nums.length; j++) {
                if (nums[i] == nums[j])
                    flag = true;
            }

            if( !flag ){
                result = nums[i];
                break;
            }
        }
        return result;*/
    }
}
