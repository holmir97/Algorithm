import java.util.Arrays;


// my soluton_USE Arrays
public class FindKthLargestElement {
    public static void main(String[] args) {
        System.out.println(new FindKthLargestElement().findKthLargest(new int[]{5, 2, 4, 3, 1},2));
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

/* USE_quickSort
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }


        private int quickSelect(int[] nums, int start, int end, int k) {
            if (start == end) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            int pivot = nums[mid];

            int i = start, j = end;
            while (i <= j) {
                while (i <= j && nums[i] < pivot) {
                    i++;
                }
                while (i <= j && nums[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            }

            if (start + k - 1 <= j) {
                return quickSelect(nums, start, j, k);
            }

            if (start + k - 1 >= i) {
                return quickSelect(nums, i, end, k-(i-start));
            }

            return nums[j+1];
        }
}
 */
