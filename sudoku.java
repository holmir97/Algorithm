import java.util.Arrays;

public class sudoku {
    public static void main(String[] args) {
        printSudoku(new sudoku().solution(new int[][]{
                {0,5,6,9,7,4,1,3,0},
                {3,4,7,2,6,1,5,9,8},
                {1,9,2,8,3,5,7,6,4},
                {7,3,4,1,9,8,2,5,6},
                {5,1,8,6,0,7,3,4,9},
                {2,6,9,5,4,3,8,7,1},
                {6,8,5,3,1,9,4,2,7},
                {9,7,1,4,5,2,6,8,3},
                {0,2,3,7,8,6,9,1,0}
        }));
    }
    public int[][] solution(int[][] sudoku) {
        int[][] answer = {};
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) {
                    sudoku[i][j] = checkNum(i,j,sudoku);
                }
            }
        }
        answer = sudoku;

        return answer;
    }


    public static int checkNum(int r, int c, int[][] sudoku) {
        String str = "";

        int[] columnLine = new int[sudoku.length];
        int[] line33 = new int[9];

        //check 행
        str = Arrays.toString(sudoku[r]);
        for (int i = 1; i < sudoku[r].length+1; i++) {
            if (checkBlank(sudoku[r]) != 1)
                break;
            if (str.contains(String.valueOf(i)))
                continue;
            else
                return i;
        }

        // check 열
        for (int i = 0; i < sudoku.length; i++)
            columnLine[i] = sudoku[i][c];
        str = Arrays.toString(columnLine);
        for (int i = 1; i < sudoku.length+1; i++) {
            if (checkBlank(columnLine) != 1)
                break;
            if (str.contains(String.valueOf(i)))
                continue;
            else
                return i;
        }

        // check 3x3
        int cnt = 0;
        int row = (r / 3) * 3; // 3x3의 행의 첫 위치
        int col = (c / 3) * 3; // 3x3의 열의 첫 위치
        for (int i = row; i < row + 3; i++) {
            for(int j = col; j< col + 3 ; j++) {
                line33[cnt++] = sudoku[i][j];
            }
        }
        str = Arrays.toString(line33);
        for (int i = 1; i < sudoku.length+1; i++) {
            if (checkBlank(line33) != 1)
                break;
            if (str.contains(String.valueOf(i)))
                continue;
            else
                return i;
        }

        return 0;
    }

    public static int checkBlank(int[] line) {
        int cnt = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 0)
                cnt++;
        }
        return cnt;
    }

    public static void printSudoku(int[][] sudoku){
        for(int i = 0 ; i<sudoku.length; i++){
            for(int j = 0; j<sudoku[i].length; j++)
                System.out.print(sudoku[i][j]);
            System.out.println();
        }
    }
}
