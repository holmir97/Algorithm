public class DailyTemperatures {
    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new DailyTemperatures().dailyTemperatures(t);
        for (int i = 0; i < result.length; i++) {
            System.out.print("[" + result[i] + "]");
        }

    }

    //my solution_Brute Force_ㅠㅠ
    public int[] dailyTemperatures(int[] T) {
        int[] days = new int[T.length];

        for (int i = 0; i < days.length; i++) {
            int j = i + 1;
            while (j < T.length) {
                if (T[i] < T[j]) {
                    days[i]++;
                    break;
                }
                days[i]++;
                j++;

                if(j == days.length)
                    days[i] =0;
            }
        }
        return days;
    }
}
/* Best Solution_USE stack_O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }
}
*/
