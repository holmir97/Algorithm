public class ShuffleArr {
    public int[] shuffle(int[] nums, int n) {
        int idx = 0;
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length;i++) {
            if (i % 2 == 0)
                arr[i] = nums[idx++];
            else
                arr[i] = nums[n++];
        }
        return arr;
    }
}
