import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kie827 on 8/14/2016.
 */
public class Sudoku {
    public static void main (String[] args) throws IOException{
        Scanner scan = new Scanner(new File("sudoku.txt"));
        int total = 0;
        while (scan.hasNextLine()){
            scan.nextLine();
            String[][] grid = new String[9][9];
            for (int i = 0 ; i < 9 ; i ++){
                String ln = scan.nextLine();
                for (int j = 0 ; j < 9 ; j ++){
                    grid[i][j] = ln.substring(j, j+1);
                }
            }
            SudokuSolver solver = new SudokuSolver(grid);
            solver.solve();
            System.out.println(solver.isSolved());
            total += solver.getTopCorner();
        }
        System.out.println(total);
    }
}
