public class MaxConsecutive {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    //solution 1
    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
                if (i == nums.length - 1 && nums[nums.length - 1] == 1) {
                    if (cnt > max) return cnt;
                    else return max;
                }
            } else if (cnt > max) {
                max = cnt;
                cnt = 0;
            } else
                cnt = 0;
        }
        return max;
    }
    //solution 2
    /*
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                cnt++;
            else
                cnt = 0;

            if (cnt > max)
                max = cnt;
        }

        return max;

    }*/
}
