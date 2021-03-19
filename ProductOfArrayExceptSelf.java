public class ProductOfArrayExceptSelf {

    // my solution _ O(n)
    public int[] productExceptSelf1(int[] nums) {
        int tmp = 1;
        int cnt = 0;
        boolean zeroFlag = false;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                cnt++;
                if(cnt == 1 )
                    continue;
            }
            tmp *= nums[i];
        }

        if(cnt != 1)
            zeroFlag = true;

        if(zeroFlag) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    nums[i] = tmp;
                else
                    nums[i] = tmp / nums[i];
            }
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    nums[i] = tmp;
                else
                    nums[i] = 0;
            }
        }
        return nums;
    }


    // my solution _ O(n^2) _ Time Limit Exceeded
    public int[] productExceptSelf2(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++)
            answer[i] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                answer[i] *= nums[j];
            }
        }
        return answer;
    }
}
