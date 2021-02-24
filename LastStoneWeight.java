//my solution
public class LastStoneWeight {
    int idx = 0;

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        int remainWeight = maxStone(stones);

        while (len != 1) {
            int max = maxStone(stones);
            if (remainWeight < max) {
                stones[this.idx] = remainWeight;
                remainWeight = max;
                continue;
            }
            remainWeight -= max;
            len--;
        }
        return remainWeight;
    }

    public int maxStone(int[] stones) {
        int max = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] > max) {
                max = stones[i];
                this.idx = i;
            }
        }

        stones[this.idx] = 0;
        return max;
    }
}

/*best solution
class Solution {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        while (len >= 2) {
            Arrays.sort(stones);

            int diff = stones[len - 1] - stones[len - 2];

            stones[--len - 1] = diff;
        }

        return stones[0];

    }
}
*/
