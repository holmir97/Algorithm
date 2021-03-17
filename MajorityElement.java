import java.util.HashMap;
import java.util.Iterator;

// my solution_USE hashmap
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2,4,4,4};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hsmap = new HashMap<>();
        int majority = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!hsmap.containsKey(nums[i]))
                hsmap.put(nums[i], 1);
            else {
                hsmap.put(nums[i], hsmap.get(nums[i]) + 1);
                System.out.println(hsmap.get(nums[i]));
            }
        }

        Iterator<Integer> iter = hsmap.keySet().iterator();
        while(iter.hasNext()){
            int tmp = iter.next();
            if(max < hsmap.get(tmp)) {
                max = hsmap.get(tmp);
                majority = tmp;
            }
        }
        return majority;
    }
}

/* Sorting solution
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
 */

/* Divide and Conquer
class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}
 */
