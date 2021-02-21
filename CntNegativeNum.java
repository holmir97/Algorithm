public class CntNegativeNum {
    public static void main(String[] args) {
        int[][] arr = {
                {4, 3, 2, -1}
                , {3, 2, 1, -1}
                , {1, 1, -1, -2}
                , {-1, -1, -2, -3}
        };
        System.out.println(countNegatives1(arr));
    }

    // #1 모든요소 검사
    public static int countNegatives1(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0)
                    cnt++;
            }
        }
        return cnt;
    }

    // gird[i][0] 이 Negative아닐때는 bruteforce
    public static int countNegatives2(int[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][0] < 0) {
                    cnt += grid[0].length * (grid.length - i);
                    return cnt;
                } else if (grid[i][j] < 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
