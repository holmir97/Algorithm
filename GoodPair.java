public class GoodPair {
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;

        if(nums.length > 100 || nums.length<1)
            return 0;

        for(int i = 0 ; i<nums.length; i++){
            if(nums[i]>100 || nums[i] <1 )
                return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    cnt++;
            }
        }
        return cnt;
    }
}
