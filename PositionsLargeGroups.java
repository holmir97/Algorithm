import java.util.ArrayList;
import java.util.List;

public class PositionsLargeGroups {

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abc").toString());
    }

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
