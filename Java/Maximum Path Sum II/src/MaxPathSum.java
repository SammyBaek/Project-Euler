/**
 * Created by kie827 on 6/7/2016.
 */
import java.util.*;
import java.io.*;

public class MaxPathSum {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("triangle.txt"));
            ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
            while (scan.hasNextLine()){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                String[] in = scan.nextLine().split(" ");
                for (String str : in)
                    temp.add(Integer.parseInt(str));
                grid.add(temp);
            }
            for (int i = 1 ; i < grid.size() ; i ++){
                ArrayList<Integer> temp = grid.get(i);
                for (int j = 0 ; j < temp.size() ; j ++){
                    if (j == 0)
                        temp.set(j, temp.get(j) + grid.get(i-1).get(j));
                    else if (j == temp.size()-1)
                        temp.set(j, temp.get(j) + grid.get(i-1).get(grid.get(i-1).size()-1));
                    else{
                        int a = grid.get(i-1).get(j) + temp.get(j);
                        int b = grid.get(i-1).get(j-1) + temp.get(j);
                        temp.set(j, Math.max(a, b));
                    }
                }
            }
            System.out.println(grid);
            int max = Integer.MIN_VALUE;
            for (int i : grid.get(grid.size()-1))
                if (i > max)
                    max = i;
            System.out.println(max);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}
