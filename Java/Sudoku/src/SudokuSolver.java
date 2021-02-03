import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by kie827 on 8/14/2016.
 */
public class SudokuSolver {
    private int[][] grid;
    private int[][] solved;
    private ArrayList<Integer>[][] possibilites = new ArrayList[9][9];

    public SudokuSolver (String[][] in){
        grid = new int[9][9];
        // check for incorrect input
        if (in.length != 9)
            throw new InputMismatchException("Not 9 columns");
        for (String[] temp : in){
            if (temp.length != 9)
                throw new InputMismatchException("Not 9 rows");
        }
        // input into grid and possibilites
        for (int i = 0 ; i < 9 ; i ++)
            for (int j = 0 ; j < 9 ; j ++){
                grid[i][j] = Integer.parseInt(in[i][j]);
                // fill possibilites
                if (grid[i][j] == 0){
                    possibilites[i][j] = getAllNumbers();
                }
                else{
                    possibilites[i][j] = new ArrayList<Integer>();
                    possibilites[i][j].add(grid[i][j]);
                }
            }
    }

    public void solve(){
        for (int i = 0 ; !this.isSolved() && i < 25 ; i ++) {
            directDeduction();
        }
        recursiveSolve(0);
        System.out.println(this);

        if (this.isSolved()){
            return;
        }
        if (solved == null){
            System.out.println(this);
            throw new InputMismatchException("Not solved by recursive stack!");
        }
        else{
            for (int row = 0 ; row < 9 ; row ++){
                for (int col = 0 ; col < 9 ; col ++){
                    grid[row][col] = solved[row][col];
                }
            }
        }
    }

    private void recursiveSolve(int position){
        if (solved != null){
            return;
        }
        if (position == 81){
            if (this.isSolved()){
                // copy to solved
                solved = new int[grid.length][grid[0].length];
                for (int row = 0 ; row < 9 ; row ++){
                    for (int col = 0 ; col < 9 ; col ++){
                        solved[row][col] = grid[row][col];
                    }
                }
            }
        }
        else {
            int row = position / 9;
            int col = position % 9;
            if (possibilites[row][col].size() == 1){
                grid[row][col] = possibilites[row][col].get(0);
                recursiveSolve(position + 1);
            }
            else {
                for (Integer num : possibilites[row][col]) {
//                    System.out.println(position);
                    if (getRow(row, col).contains(num))
                        continue;
                    if (getCol(col, row).contains(num))
                        continue;
                    grid[row][col] = num;
                    recursiveSolve(position + 1);
                }
            }
        }
    }

    private boolean isCorrect(){
        // check row
        for (int row = 0 ; row < 9 ; row ++){
            if (!hasAllNumbers(getRow(row)))
                return false;
        }
        // check col
        for (int col = 0 ; col < 9 ; col ++){
            if (!hasAllNumbers(getCol(col)))
                return false;
        }
        //check subSquare
        for (int row = 0 ; row < 3 ; row ++){
            for (int col = 0 ; col < 3 ; col ++){
                ArrayList<Integer> temp = getSubSquare(row*3, col*3);
                if (!hasAllNumbers(temp))
                    return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> getRow(int row){
        return getRow(row, 9);
    }

    private ArrayList<Integer> getRow(int row, int pos){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int col = 0 ; col < pos ; col ++){
            temp.add(grid[row][col]);
        }
        return temp;
    }

    private ArrayList<Integer> getCol(int col){
        return getCol(col, 9);
    }

    private ArrayList<Integer> getCol(int col, int pos){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int row = 0 ; row < pos ; row ++){
            temp.add(grid[row][col]);
        }
        return temp;
    }

    private boolean isFilled(){
        for (int[] row : grid)
            for (int num : row)
                if (num == 0)
                    return false;
        return true;
    }

    public boolean isSolved(){
        return isCorrect() && isFilled();
    }

    private boolean hasAllNumbers(ArrayList<Integer> list){
        if (list.size() != 9)
            return false;
        for (int i = 1 ; i <= 9 ; i ++)
            if (!list.contains(i))
                return false;
        return true;
    }

    private void directDeduction(){
        for (int row = 0 ; row < 9 ; row ++){
            for (int col = 0 ; col < 9 ; col ++){
                if (grid[row][col] != 0)
                    continue;
                ArrayList<Integer> temp = possibilites[row][col];
                // reduce row
                for (int c = 0 ; c < 9 ; c ++){
                    temp.remove(new Integer(grid[row][c]));
                }
                // reduce col
                for (int r = 0 ; r < 9 ; r ++){
                    temp.remove(new Integer(grid[r][col]));
                }
                // reduce sub-square
                ArrayList<Integer> subSquare = getSubSquareExcludeCurrent(row, col);
                for (Integer i : subSquare)
                    temp.remove(i);
                if (temp.size() == 0)
                    throw new InputMismatchException("Incorrect Deduction: no possibilites left");
                if (temp.size() == 1)
                    grid[row][col] = temp.get(0);
            }
        }
    }

    private ArrayList<Integer> getSubSquareExcludeCurrent(int givenRow, int givenCol){
        ArrayList<Integer> temp = getSubSquare(givenRow, givenCol);
        temp.remove(temp.size()-1);
        return temp;
    }

    private ArrayList<Integer> getSubSquare(int givenRow, int givenCol){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int row = givenRow / 3;
        int col = givenCol / 3;
        for (int r = 0 ; r < 3 ; r ++){
            for (int c = 0 ; c < 3 ; c ++){
                if (givenRow == row*3 + r && givenCol == col*3 + c)
                    continue;
                int num = grid[row*3 + r][col*3 + c];
                if (!temp.contains(num))
                    temp.add(num);
            }
        }
        temp.add(grid[givenRow][givenCol]);
        temp.remove(new Integer(0));
        return temp;
    }

    private ArrayList<Integer> getAllNumbers(){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 1 ; i <= 9 ; i ++)
            temp.add(i);
        return temp;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Puzzle:\n");
        for (int[] temp : grid){
            builder.append(Arrays.toString(temp) + "\n");
        }
        builder.append("Possibilities:\n");
        for (ArrayList<Integer>[] temp : possibilites)
            builder.append(Arrays.toString(temp) + "\n");
        return builder.toString();
    }

    public int getTopCorner(){
        return grid[0][0] * 100 + grid[0][1] * 10 + grid[0][2];
    }
}
