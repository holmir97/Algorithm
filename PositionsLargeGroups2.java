// leetcode
// 2021.04.08
// wrong answer

import java.util.ArrayList;
import java.util.List;


// 예외 케이스 발생, 다시 해볼것!
public class PositionsLargeGroups2 {

//    public static void main(String[] args) {
//        System.out.println(largeGroupPositions("abc").toString());
//    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> position = new ArrayList<>();
        StringBuffer str = new StringBuffer(s);
        int cnt = 1, max = 0, idx = 0;
        char tmp = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (tmp == str.charAt(i)) {
                cnt++;
                if (i == str.length() - 1)
                    if (cnt > max) {
                        max = cnt;
                        idx = i;
                    }
            } else {
                if (cnt > max) {
                    max = cnt;
                    idx = i;
                }
                cnt = 1;
                tmp = str.charAt(i);
            }
        }
        if (max == 1)
            return solution;
        else {
            position.add(idx - max);
            position.add(idx - 1);
            solution.add(position);
        }
        return solution;
    }
}

// best solution_USE Two Pointer
/*
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }
}
 */
