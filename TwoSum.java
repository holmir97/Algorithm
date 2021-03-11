public class TwoSum {
    public static void main(String[] args) {
        int[] a = {3,2,4};
        new TwoSum().twoSum(a, 6);
    }

    //my solution
    public int[] twoSum(int[] nums, int target) {
        int idx[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    idx[0] = i;
                    idx[1] = j;
                    return idx;
                }
            }
        }
        return idx;
    }
}

/* best solution
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
 */
