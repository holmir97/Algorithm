// LeetCode_33
// 2020.04.13
// 이분 탐색, Brute force
// Medium


// 이분탐색_O(logn)
public class SearchInRotatedArr {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArr().search( new int[]{5,1,3},5));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int mid;
        int right = nums.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] <= nums[mid]) {
                if (nums[mid] < target || (nums[mid] > target && nums[left] > target))
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[mid] > target || (nums[mid] < target && nums[right] < target))
                    right = mid - 1;
                else
                    left = mid + 1;
            }

        }
        return -1;
    }
}


//// Brute force_O(n)

//public class SearchInRotatedArr {
//    public int search(int[] nums, int target) {
//        int i;
//        for(i = 0; i<nums.length;i++) {
//            if (nums[i] == target)
//                return i;
//        }
//
//        return -1;
//    }
//}