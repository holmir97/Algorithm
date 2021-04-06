// GreedyAlgorithm
// my solution_O(n)
public class JumpGame2 {
    public int jump(int[] nums) {
        int maxStep = 0;
        int cnt = 0;
        int minStep = 0;

        if (nums.length == 0 || nums.length ==1)
            return 0;


        for (int i = 0; i < nums.length; i++) {
            // 최대 접근 가능 위치 삽입
            maxStep = Math.max(maxStep, i + nums[i]);
            if(i == minStep) {
                if(i == nums.length-1)
                    break;
                minStep = maxStep;
                cnt++; //이동
            }
        }
        return cnt;
    }
}

/*  DP
*   Another Solution
class Solution {
    public int jump(int[] nums) {
        int[] cache = new int[nums.length];

        cache[0] = 0;

        for (int i = 1; i < cache.length; i++) {
            cache[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int next = Math.min(i+j, nums.length-1);

                cache[next] = Math.min(cache[next], 1 + cache[i]);
            }
        }

        return cache[nums.length-1];
    }
}
*/